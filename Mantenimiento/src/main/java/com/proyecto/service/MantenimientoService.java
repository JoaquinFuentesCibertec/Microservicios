package com.proyecto.service;

import com.proyecto.model.Mantenimiento;
import com.proyecto.repository.IMantenimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MantenimientoService {

    @Autowired
    private IMantenimientoRepository mantenimientoRepository;

    public Mantenimiento obtenerPorId(Long id) {
        Optional<Mantenimiento> optionalMantenimiento = mantenimientoRepository.findById(id);
        return optionalMantenimiento.orElse(null);
    }

    public List<Mantenimiento> listarPorIdSucursal(Long idSucursal) {
        return mantenimientoRepository.findByIdSucursal(idSucursal);
    }

    public List<Mantenimiento> listarTodos() {
        return mantenimientoRepository.findAll();
    }

    public Mantenimiento registrarMantenimiento(Mantenimiento mantenimiento) {
        return mantenimientoRepository.save(mantenimiento);
    }
    
    public Mantenimiento actualizarMantenimiento(Mantenimiento mantenimiento) {
        return mantenimientoRepository.save(mantenimiento);
    }
    
    public void eliminarMantenimiento(Long id) {
        mantenimientoRepository.deleteById(id);
    }
}
