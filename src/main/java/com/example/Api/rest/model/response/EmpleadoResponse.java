package com.example.Api.rest.model.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
@Builder
@Data

public class EmpleadoResponse {
    private Long id;
    private String dni;
    private String nombre;
    private String apellidos;
    private int edad;
    private double salario;
    private LocalDate fecha_contratacion;
    private LocalDate fecha_finalizacion;
    private String estado;
}
