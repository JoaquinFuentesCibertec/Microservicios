package com.proyecto.models;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Libro {
	
    private Long id;
    private String nombre;
    private String autor;
    private String pais;
    private Integer stock;
    private Date fechaRestock;
    private transient List<Editorial> editoriales;

}
