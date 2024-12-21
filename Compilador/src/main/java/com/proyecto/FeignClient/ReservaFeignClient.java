package com.proyecto.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.proyecto.models.Reserva;

import java.util.List;

@FeignClient(name = "reservaClient", url = "http://localhost:8082/api")
public interface ReservaFeignClient {

    @GetMapping("/reservas")
    List<Reserva> listarTodas();

    @GetMapping("/reservas/{id}")
    Reserva obtenerPorId(@PathVariable Long id);

    @PostMapping("/reservas")
    Reserva registrarReserva(@RequestBody Reserva reserva);

    @PutMapping("/reservas/{id}")
    Reserva actualizarReserva(@PathVariable Long id, @RequestBody Reserva reserva);

    @DeleteMapping("/reservas/{id}")
    void eliminarReserva(@PathVariable Long id);

    @GetMapping("/reservas/cliente/{idCliente}")
    List<Reserva> listarPorIdCliente(@PathVariable Long idCliente);
}
