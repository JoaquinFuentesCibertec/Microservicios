package com.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.model.Reserva;

@Repository
public interface IReservaRepository extends JpaRepository<Reserva, Long>{
	List<Reserva> findByIdCliente(Long idCliente);
}
