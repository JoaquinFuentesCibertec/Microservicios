package com.proyecto.reserva;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "reserva-service", url = "http://localhost:8082/api")
public interface ClienteReserva {
	
	@GetMapping("/reservas/cliente/{idCliente}")
    List<Reserva> obtenerReservasPorCliente(@PathVariable("idCliente") Long idCliente);

}
