package com.proyecto.controller;

import com.proyecto.models.Reserva;
import com.proyecto.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping("/reservas")
    public List<Reserva> listarTodas() {
        return reservaService.listarTodas();
    }

    @GetMapping("/reservas/{id}")
    public Reserva obtenerPorId(@PathVariable Long id) {
        return reservaService.obtenerPorId(id);
    }

    @PostMapping("/reservas")
    public Reserva registrarReserva(@RequestBody Reserva reserva) {
        return reservaService.registrarReserva(reserva);
    }

    @PutMapping("/reservas/{id}")
    public Reserva actualizarReserva(@PathVariable Long id, @RequestBody Reserva reserva) {
        return reservaService.actualizarReserva(id, reserva);
    }

    @DeleteMapping("/reservas/{id}")
    public void eliminarReserva(@PathVariable Long id) {
        reservaService.eliminarReserva(id);
    }

    @GetMapping("/reservas/cliente/{idCliente}")
    public List<Reserva> listarPorIdCliente(@PathVariable Long idCliente) {
        return reservaService.listarPorIdCliente(idCliente);
    }
}
