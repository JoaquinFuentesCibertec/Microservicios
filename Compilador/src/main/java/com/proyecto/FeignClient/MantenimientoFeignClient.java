package com.proyecto.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.proyecto.models.Mantenimiento;

import java.util.List;

@FeignClient(name = "mantenimientoClient", url = "http://localhost:8086/api")
public interface MantenimientoFeignClient {

    @GetMapping("/mantenimientos")
    List<Mantenimiento> listarTodos();

    @GetMapping("/mantenimientos/{id}")
    Mantenimiento obtenerPorId(@PathVariable Long id);

    @PostMapping("/mantenimientos")
    Mantenimiento registrarMantenimiento(@RequestBody Mantenimiento mantenimiento);

    @PutMapping("/mantenimientos/{id}")
    Mantenimiento actualizarMantenimiento(@PathVariable Long id, @RequestBody Mantenimiento mantenimiento);

    @DeleteMapping("/mantenimientos/{id}")
    void eliminarMantenimiento(@PathVariable Long id);

    @GetMapping("/mantenimientos/sucursal/{idSucursal}")
    List<Mantenimiento> listarPorIdSucursal(@PathVariable Long idSucursal);
}
