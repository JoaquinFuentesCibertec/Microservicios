package com.proyecto.service;

import com.proyecto.mantenimiento.Mantenimiento;
import com.proyecto.mantenimiento.SucursalMantenimiento;
import com.proyecto.model.Sucursal;
import com.proyecto.repository.ISucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SucursalService {

    @Autowired
    private ISucursalRepository sucursalRepository;
    
    @Autowired
    private SucursalMantenimiento mantenimientoFeignClient;

    public List<Sucursal> listarTodos() {
        return sucursalRepository.findAll();
    }

    public Sucursal obtenerPorId(Long id) {
        Optional<Sucursal> optionalSucursal = sucursalRepository.findById(id);
        return optionalSucursal.orElse(null);
    }

    public Sucursal registrarSucursal(Sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }

    public Sucursal actualizarSucursal(Sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }

    public void eliminarSucursal(Long id) {
        sucursalRepository.deleteById(id);
    }
    
    public Sucursal obtenerSucursalConMantenimientos(Long id) {
        Optional<Sucursal> optionalSucursal = sucursalRepository.findById(id);
        if (optionalSucursal.isPresent()) {
            Sucursal sucursal = optionalSucursal.get();
            List<Mantenimiento> mantenimientos = mantenimientoFeignClient.listarPorIdSucursal(sucursal.getId());
            sucursal.setMantenimientos(mantenimientos);
            return sucursal;
        }
        return null;
    }
}
