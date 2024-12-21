package com.proyecto.mantenimiento;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "mantenimiento-service", url = "http://localhost:8086/api")
public interface SucursalMantenimiento {
	
	 @GetMapping("/mantenimientos/sucursal/{idSucursal}")
	    List<Mantenimiento> listarPorIdSucursal(@PathVariable("idSucursal") Long idSucursal);

}
