package com.example.Api.rest.service;

import com.example.Api.rest.model.domain.Empleado;
import com.example.Api.rest.model.domain.EmpleadoEstado;
import com.example.Api.rest.model.request.EmpleadoRequest;
import com.example.Api.rest.model.response.EmpleadoResponse;
import com.example.Api.rest.repository.EmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoRepository empleadoRepository;
    @Override
    public List<EmpleadoResponse> obtenerTodosLosEmpleadosActivos() {
        List<Empleado> empleadosActivos = empleadoRepository.findByEstadoAndEliminacionFalse(EmpleadoEstado.ACTIVO);
        return empleadosActivos.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());}

    @Override
    public EmpleadoResponse crearEmpleado(EmpleadoRequest request) {
        Empleado empleado = Empleado.builder()
                .dni(request.getDni())
                .nombre(request.getNombre())
                .apellidos(request.getApellidos())
                .edad(request.getEdad())
                .salario(request.getSalario())
                .fecha_contratacion(request.getFecha_contratacion())
                .fecha_finalizacion(request.getFecha_finalizacion())
                .estado(EmpleadoEstado.ACTIVO)
                .build();

        Empleado empleadoGuardado = empleadoRepository.save(empleado);
        return mapToResponse(empleadoGuardado);
    }

    @Override
    public EmpleadoResponse obtenerEmpleado(Long id) {
        Empleado empleado = empleadoRepository.findByIdAndEliminacionIsFalse(id)
                .orElseThrow(() -> new IllegalArgumentException("Empleado no encontrado"));

        return mapToResponse(empleado);
    }

    @Override
    public void actualizarEmpleado(Long id, EmpleadoRequest request) {
        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Empleado no encontrado"));

        empleado.setDni(request.getDni());
        empleado.setNombre(request.getNombre());
        empleado.setApellidos(request.getApellidos());
        empleado.setEdad(request.getEdad());
        empleado.setSalario(request.getSalario());
        empleado.setFecha_contratacion(request.getFecha_contratacion());
        empleado.setFecha_finalizacion(request.getFecha_finalizacion());
        empleado.setEstado(request.getEstado());

        empleado.actualizarEstado();

        empleadoRepository.save(empleado);
    }

    @Override
    public void eliminarEmpleado(Long id) {
        Empleado empleado = empleadoRepository.findByIdAndEliminacionIsFalse(id)
                .orElseThrow(() -> new IllegalArgumentException("Empleado no encontrado"));

        empleado.marcarComoEliminado();
        empleadoRepository.save(empleado);
    }

    private EmpleadoResponse mapToResponse(Empleado empleado) {
        String estado = empleado.getEstado().name(); // Obtener el nombre del estado como String
        return EmpleadoResponse.builder()
                .id(empleado.getId())
                .dni(empleado.getDni())
                .nombre(empleado.getNombre())
                .apellidos(empleado.getApellidos())
                .edad(empleado.getEdad())
                .salario(empleado.getSalario())
                .fecha_contratacion(empleado.getFecha_contratacion())
                .fecha_finalizacion(empleado.getFecha_finalizacion())
                .estado(estado)
                .build();
    }
}


