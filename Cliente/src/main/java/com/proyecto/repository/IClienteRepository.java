package com.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.model.Cliente;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long> {

}
