package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.FeignClient.MantenimientoFeignClient;
import com.proyecto.models.Mantenimiento;

@Service
public class MantenimientoService {

    @Autowired
    private MantenimientoFeignClient mantenimientoFeignClient;

    public List<Mantenimiento> listarTodos() {
        return mantenimientoFeignClient.listarTodos();
    }

    public Mantenimiento obtenerPorId(Long id) {
        return mantenimientoFeignClient.obtenerPorId(id);
    }

    public Mantenimiento registrarMantenimiento(Mantenimiento mantenimiento) {
        return mantenimientoFeignClient.registrarMantenimiento(mantenimiento);
    }

    public Mantenimiento actualizarMantenimiento(Long id, Mantenimiento mantenimiento) {
        return mantenimientoFeignClient.actualizarMantenimiento(id, mantenimiento);
    }

    public void eliminarMantenimiento(Long id) {
        mantenimientoFeignClient.eliminarMantenimiento(id);
    }

    public List<Mantenimiento> listarPorIdSucursal(Long idSucursal) {
        return mantenimientoFeignClient.listarPorIdSucursal(idSucursal);
    }

}
