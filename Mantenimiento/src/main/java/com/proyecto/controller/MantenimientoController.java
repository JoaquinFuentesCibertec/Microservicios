package com.proyecto.controller;

import com.proyecto.model.Mantenimiento;
import com.proyecto.service.MantenimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MantenimientoController {

    @Autowired
    private MantenimientoService mantenimientoService;

    @GetMapping("/mantenimientos")
    public List<Mantenimiento> listarTodos() {
        return mantenimientoService.listarTodos();
    }

    @GetMapping("/mantenimientos/{id}")
    public Mantenimiento obtenerPorId(@PathVariable Long id) {
        return mantenimientoService.obtenerPorId(id);
    }

    @PostMapping("/mantenimientos")
    public Mantenimiento registrarMantenimiento(@RequestBody Mantenimiento mantenimiento) {
        return mantenimientoService.registrarMantenimiento(mantenimiento);
    }

    @PutMapping("/mantenimientos/{id}")
    public Mantenimiento actualizarMantenimiento(@PathVariable Long id, @RequestBody Mantenimiento mantenimiento) {
        mantenimiento.setId(id);
        return mantenimientoService.actualizarMantenimiento(mantenimiento);
    }

    @DeleteMapping("/mantenimientos/{id}")
    public void eliminarMantenimiento(@PathVariable Long id) {
        mantenimientoService.eliminarMantenimiento(id);
    }

    @GetMapping("/mantenimientos/sucursal/{idSucursal}")
    public List<Mantenimiento> listarPorIdSucursal(@PathVariable Long idSucursal) {
        return mantenimientoService.listarPorIdSucursal(idSucursal);
    }
}
