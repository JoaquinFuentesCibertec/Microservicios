package com.proyecto.service;

import com.proyecto.FeignClient.ClienteFeignClient;
import com.proyecto.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteFeignClient clienteFeignClient;

    public List<Cliente> listarTodos() {
        return clienteFeignClient.listarTodos();
    }

    public Cliente obtenerPorId(Long id) {
        return clienteFeignClient.obtenerPorId(id);
    }

    public Cliente registrarCliente(Cliente cliente) {
        return clienteFeignClient.registrarCliente(cliente);
    }

    public Cliente actualizarCliente(Long id, Cliente cliente) {
        return clienteFeignClient.actualizarCliente(id, cliente);
    }

    public void eliminarCliente(Long id) {
        clienteFeignClient.eliminarCliente(id);
    }

    public Cliente obtenerPorIdConReservas(Long id) {
        return clienteFeignClient.obtenerPorIdConReservas(id);
    }
}

