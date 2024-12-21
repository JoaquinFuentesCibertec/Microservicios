package com.proyecto.controller;

import com.proyecto.models.Sucursal;
import com.proyecto.service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    @GetMapping("/sucursales")
    public List<Sucursal> listarTodas() {
        return sucursalService.listarTodas();
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
        return sucursalService.actualizarSucursal(id, sucursal);
    }

    @DeleteMapping("/sucursales/{id}")
    public void eliminarSucursal(@PathVariable Long id) {
        sucursalService.eliminarSucursal(id);
    }
    
    @GetMapping("sucursales/sucursalMantenimiento/{id}")
    public Sucursal obtenerSucursalConMantenimientos(@PathVariable Long id) {
        return sucursalService.obtenerSucursalConMantenimientos(id);
    }
}
