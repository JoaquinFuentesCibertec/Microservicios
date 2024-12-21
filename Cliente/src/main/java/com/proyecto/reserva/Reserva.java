package com.proyecto.reserva;

import lombok.Data;
import java.util.Date;

@Data
public class Reserva {
    private Long id;
    private Long idCliente;
    private String libroReservado;
    private Date fechaReserva;
}
