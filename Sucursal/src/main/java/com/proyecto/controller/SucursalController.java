package com.proyecto.controller;

import com.proyecto.model.Sucursal;
import com.proyecto.service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    @GetMapping("/sucursales")
    public List<Sucursal> listarTodos() {
        return sucursalService.listarTodos();
    }

    @GetMapping("/sucursales/{id}")
    public Sucursal obtenerPorId(@PathVariable Long id) {
        return sucursalService.obtenerPorId(id);
    }

    @PostMapping("/sucursales")
    public Sucursal registrarSucursal(@RequestBody Sucursal sucursal) {
        return sucursalService.registrarSucursal(sucursal);
    }

    @PutMapping("/sucursales/{id}")
    public Sucursal actualizarSucursal(@PathVariable Long id, @RequestBody Sucursal sucursal) {
        sucursal.setId(id);
        return sucursalService.actualizarSucursal(sucursal);
    }

    @DeleteMapping("/sucursales/{id}")
    public void eliminarSucursal(@PathVariable Long id) {
        sucursalService.eliminarSucursal(id);
    }
    
    @GetMapping("/sucursalMantenimiento/{id}")
    public Sucursal obtenerSucursalConMantenimientos(@PathVariable Long id) {
        return sucursalService.obtenerSucursalConMantenimientos(id);
    }
}
