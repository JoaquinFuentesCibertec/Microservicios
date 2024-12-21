package com.proyecto.service;

import com.proyecto.FeignClient.SucursalFeignClient;
import com.proyecto.models.Sucursal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucursalService {

    @Autowired
    private SucursalFeignClient sucursalFeignClient;

    public List<Sucursal> listarTodas() {
        return sucursalFeignClient.listarTodos();
    }

    public Sucursal obtenerPorId(Long id) {
        return sucursalFeignClient.obtenerPorId(id);
    }

    public Sucursal registrarSucursal(Sucursal sucursal) {
        return sucursalFeignClient.registrarSucursal(sucursal);
    }

    public Sucursal actualizarSucursal(Long id, Sucursal sucursal) {
        return sucursalFeignClient.actualizarSucursal(id, sucursal);
    }

    public void eliminarSucursal(Long id) {
        sucursalFeignClient.eliminarSucursal(id);
    }

    public Sucursal obtenerSucursalConMantenimientos(Long id) {
        return sucursalFeignClient.obtenerSucursalConMantenimientos(id);
    }
}
