package com.example.Api.rest.controller;

import com.example.Api.rest.model.request.EmpleadoRequest;
import com.example.Api.rest.model.response.EmpleadoResponse;
import com.example.Api.rest.service.EmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
@RequiredArgsConstructor
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    @GetMapping
    public ResponseEntity<List<EmpleadoResponse>> obtenerTodosLosEmpleadosActivos() {
        List<EmpleadoResponse> empleadosActivos = empleadoService.obtenerTodosLosEmpleadosActivos();
        return ResponseEntity.ok(empleadosActivos);
    }

    @PostMapping
    public ResponseEntity<EmpleadoResponse> crearEmpleado(@RequestBody EmpleadoRequest request) {
        EmpleadoResponse response = empleadoService.crearEmpleado(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoResponse> obtenerEmpleado(@PathVariable Long id) {
        EmpleadoResponse response = empleadoService.obtenerEmpleado(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizarEmpleado(
            @PathVariable Long id,
            @RequestBody EmpleadoRequest request
    ) {
        empleadoService.actualizarEmpleado(id, request);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEmpleado(@PathVariable Long id) {
        empleadoService.eliminarEmpleado(id);
        return ResponseEntity.noContent().build();
    }
}