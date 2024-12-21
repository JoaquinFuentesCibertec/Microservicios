package com.proyecto.service;

import com.proyecto.model.Cliente;
import com.proyecto.repository.IClienteRepository;
import com.proyecto.reserva.ClienteReserva;
import com.proyecto.reserva.Reserva;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
	@Autowired
	private ClienteReserva reservaFeignClient;

    @Autowired
    private IClienteRepository clienteRepository;

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Cliente obtenerPorId(Long id) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);
        return optionalCliente.orElse(null);
    }

    public Cliente registrarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente actualizarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
    
    public Cliente obtenerClienteConReservas(Long id) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);
        if (optionalCliente.isPresent()) {
            Cliente cliente = optionalCliente.get();
            List<Reserva> reservas = reservaFeignClient.obtenerReservasPorCliente(cliente.getId());
            cliente.setReservas(reservas);
            return cliente;
        }
        return null;
    }
    
}
