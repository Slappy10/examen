package com.example.Api.rest.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "El campo DNI no debe ser nulo")
    @Size(min = 8, max = 8, message = "El DNI debe tener un tamaño fijo de 8 caracteres")
    @NotBlank(message = "El DNI no debe estar en blanco")
    @Pattern(regexp = "\\d*", message = "El DNI debe estar formado por sólo números")
    @Column(name = "dni", nullable = false, length = 8, unique = true)
    private String dni;

    @NotNull(message = "El campo Nombre no debe ser nulo")
    @NotEmpty(message = "El nombre no debe estar vacío")
    @NotBlank(message = "El nombre no debe estar en blanco")
    @Size(max = 100, message = "El nombre debe tener como máximo {max} caracteres")
    @Column(name = "nombres", nullable = false, length = 100)
    private String nombre;

    @NotNull(message = "El campo Apellidos no debe ser nulo")
    @NotEmpty(message = "Los apellidos no deben estar vacíos")
    @NotBlank(message = "Los apellidos no deben estar en blanco")
    @Size(max = 45, message = "Los apellidos deben tener como máximo {max} caracteres")
    @Column(name = "apellidos", nullable = false, length = 45)
    private String apellidos;

    @NotNull(message = "El campo Edad no debe ser nulo")
    @Min(value = 18, message = "La edad mínima debe ser 18")
    @Column(name = "edad", nullable = false)
    private Integer edad;

    @NotNull(message = "El campo Salario no debe ser nulo")
    @Min(value = 0, message = "El salario mínimo debe ser 0")
    @Column(name = "salario", nullable = false)
    private Double salario;

    @NotNull(message = "El campo Fecha de Contratación no debe ser nulo")
    @Column(name = "fecha_contratacion", nullable = false)
    private LocalDate fecha_contratacion;

    @Column(name = "fecha_finalizacion")
    private LocalDate fecha_finalizacion;

    @NotNull(message = "El campo Estado no debe ser nulo")
    @Column(name = "stado", nullable = false)
    @Enumerated(EnumType.STRING)
    private EmpleadoEstado estado;

    @Column(name = "eliminacion", nullable = false)
    private boolean eliminacion;

    public void marcarComoEliminado() {
        this.eliminacion = true;
    }

    public boolean esActivo() {
        return this.estado == EmpleadoEstado.ACTIVO && !this.eliminacion;
    }

    public void actualizarEstado() {
        if (fecha_finalizacion != null && fecha_finalizacion.isBefore(LocalDate.now())) {
            estado = EmpleadoEstado.INACTIVO;
        }
    }
}
