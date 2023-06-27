package com.example.Api.rest.repository;

import com.example.Api.rest.model.domain.Empleado;
import com.example.Api.rest.model.domain.EmpleadoEstado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    Optional<Empleado> findByIdAndEliminacionIsFalse(Long id);

    List<Empleado> findByEstadoAndEliminacionFalse(EmpleadoEstado empleadoEstado);
}