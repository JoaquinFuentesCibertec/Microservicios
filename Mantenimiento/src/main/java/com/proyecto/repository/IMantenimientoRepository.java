package com.proyecto.repository;

import com.proyecto.model.Mantenimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMantenimientoRepository extends JpaRepository<Mantenimiento, Long> {
    List<Mantenimiento> findByIdSucursal(Long idSucursal);
}
