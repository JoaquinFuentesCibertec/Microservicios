package com.proyecto.models;

import lombok.Data;

@Data
public class Editorial {
	private Long id;
	private String nombre;
	private String direccion;
	private String telefono;
	private String email;
	private Long idLibro;

}
