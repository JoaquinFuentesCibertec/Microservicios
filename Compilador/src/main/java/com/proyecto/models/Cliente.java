package com.proyecto.models;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Cliente {
	private Long id;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String direccion;
	private String correo;
	private Date fechaIngreso;
	private transient List<Reserva> reservas;

}
