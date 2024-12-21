package com.proyecto.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.proyecto.models.Sucursal;

import java.util.List;

@FeignClient(name = "sucursalClient", url = "http://localhost:8085/api")
public interface SucursalFeignClient {

    @GetMapping("/sucursales")
    List<Sucursal> listarTodos();

    @GetMapping("/sucursales/{id}")
    Sucursal obtenerPorId(@PathVariable Long id);

    @PostMapping("/sucursales")
    Sucursal registrarSucursal(@RequestBody Sucursal sucursal);

    @PutMapping("/sucursales/{id}")
    Sucursal actualizarSucursal(@PathVariable Long id, @RequestBody Sucursal sucursal);

    @DeleteMapping("/sucursales/{id}")
    void eliminarSucursal(@PathVariable Long id);

    @GetMapping("/sucursalMantenimiento/{id}")
    Sucursal obtenerSucursalConMantenimientos(@PathVariable Long id);
}
