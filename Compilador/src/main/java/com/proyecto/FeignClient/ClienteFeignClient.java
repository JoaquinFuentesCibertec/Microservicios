package com.proyecto.FeignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.proyecto.models.Cliente;

@FeignClient(name = "cliente-service", url = "http://localhost:8081/api")
public interface ClienteFeignClient {
	
	@GetMapping("/clientes")
    List<Cliente> listarTodos();

    @GetMapping("/clientes/{id}")
    Cliente obtenerPorId(@PathVariable("id") Long id);

    @PostMapping("/clientes")
    Cliente registrarCliente(@RequestBody Cliente cliente);

    @PutMapping("/clientes/{id}")
    Cliente actualizarCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente);

    @DeleteMapping("/clientes/{id}")
    void eliminarCliente(@PathVariable("id") Long id);
    
    @GetMapping("/clienteReserva/{id}")
    Cliente obtenerPorIdConReservas(@PathVariable("id") Long id);

}
