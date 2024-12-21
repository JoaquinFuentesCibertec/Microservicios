package com.proyecto.models;

import java.util.List;

import lombok.Data;

@Data
public class Sucursal {
	private Long id;
	private String nombre;
    private String direccion;
    private String tecnico;
    private String telefono;
    private transient List<Mantenimiento> mantenimientos;

}
