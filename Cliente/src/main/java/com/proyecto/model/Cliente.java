package com.proyecto.model;

import java.util.Date;
import java.util.List;

import com.proyecto.reserva.Reserva;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Cliente")
@Data
public class Cliente {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @Column(name = "nombre_cliente")
    private String nombre;

    @Column(name = "apellido_paterno")
    private String apellidoPaterno;

    @Column(name = "apellido_materno")
    private String apellidoMaterno;

    @Column(name = "direccion_cliente")
    private String direccion;

    @Column(name = "correo_electronico")
    private String correo;

    @Column(name = "fecha_ingreso")
    private Date fechaIngreso;
    
    private transient List<Reserva> reservas;
}
