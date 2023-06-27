package com.example.Api.rest.service;

import com.example.Api.rest.model.request.EmpleadoRequest;
import com.example.Api.rest.model.response.EmpleadoResponse;

import java.util.List;

public interface EmpleadoService {
    List<EmpleadoResponse> obtenerTodosLosEmpleadosActivos();
    public EmpleadoResponse crearEmpleado(EmpleadoRequest request);
    public EmpleadoResponse obtenerEmpleado(Long id);
    public void actualizarEmpleado(Long id, EmpleadoRequest request);
    public void eliminarEmpleado(Long id);
}
