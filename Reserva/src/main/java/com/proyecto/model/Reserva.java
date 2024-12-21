package com.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "Reserva")
@Data
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Long id;

    @Column(name = "id_cliente")
    private Long idCliente;

    @Column(name = "fecha_reserva")
    private Date fechaReserva;

    @Column(name = "libro_reservado")
    private String libroReservado;

    @Column(name = "fecha_recogida")
    private Date fechaRecogida;
}
