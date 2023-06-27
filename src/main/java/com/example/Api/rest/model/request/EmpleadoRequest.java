package com.example.Api.rest.model.request;

import com.example.Api.rest.model.domain.EmpleadoEstado;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;
@Data
@Builder
public class EmpleadoRequest {
    @NotNull(message = "El campo DNI no debe ser nulo")
    @Size(min = 8, max = 8, message = "El DNI debe tener un tamaño fijo de 8 caracteres")
    @NotBlank(message = "El DNI no debe estar en blanco")
    @Pattern(regexp = "\\d*", message = "El DNI debe estar formado por sólo números")
    private String dni;

    @NotNull(message = "El campo Nombre no debe ser nulo")
    @NotEmpty(message = "El nombre no debe estar vacío")
    @NotBlank(message = "El nombre no debe estar en blanco")
    @Size(max = 50, message = "El nombre debe tener como máximo {max} caracteres")
    private String nombre;

    @NotNull(message = "El campo Apellidos no debe ser nulo")
    @NotEmpty(message = "Los apellidos no deben estar vacíos")
    @NotBlank(message = "Los apellidos no deben estar en blanco")
    @Size(max = 50, message = "Los apellidos deben tener como máximo {max} caracteres")
    private String apellidos;

    @NotNull(message = "El campo Edad no debe ser nulo")
    @Min(value = 18, message = "La edad mínima debe ser 18")
    private Integer edad;

    @NotNull(message = "El campo Salario no debe ser nulo")
    @Min(value = 1000, message = "El salario mínimo debe ser 1000")
    private Double salario;

    @NotNull(message = "El campo Fecha de Contratación no debe ser nulo")
    private LocalDate fecha_contratacion;

    private LocalDate fecha_finalizacion;

    @NotNull(message = "El campo Estado no debe ser nulo")
    private EmpleadoEstado estado;
}
