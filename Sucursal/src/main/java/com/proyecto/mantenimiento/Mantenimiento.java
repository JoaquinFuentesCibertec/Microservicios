package com.proyecto.mantenimiento;

import java.util.Date;

import lombok.Data;

@Data
public class Mantenimiento {
	private Long id;
	private Date fechaInicio;
	private Date fechaFin;
	private String razon;
	private Long idSucursal;
	

}
