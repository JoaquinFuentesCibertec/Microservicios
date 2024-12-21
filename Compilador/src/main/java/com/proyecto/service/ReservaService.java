package com.proyecto.service;

import com.proyecto.FeignClient.ReservaFeignClient;
import com.proyecto.models.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaFeignClient reservaFeignClient;

    public List<Reserva> listarTodas() {
        return reservaFeignClient.listarTodas();
    }

    public Reserva obtenerPorId(Long id) {
        return reservaFeignClient.obtenerPorId(id);
    }

    public Reserva registrarReserva(Reserva reserva) {
        return reservaFeignClient.registrarReserva(reserva);
    }

    public Reserva actualizarReserva(Long id, Reserva reserva) {
        return reservaFeignClient.actualizarReserva(id, reserva);
    }

    public void eliminarReserva(Long id) {
        reservaFeignClient.eliminarReserva(id);
    }

    public List<Reserva> listarPorIdCliente(Long idCliente) {
        return reservaFeignClient.listarPorIdCliente(idCliente);
    }
}
