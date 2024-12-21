package com.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.Date;
import java.util.List;

import com.proyecto.editorial.Editorial;

@Entity
@Table(name = "Libro")
@Data
public class Libro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre_libro")
    private String nombre;
    
    @Column(name = "autor")
    private String autor;
    
    @Column(name = "pais")
    private String pais;
    
    @Column(name = "stock")
    private Integer stock;
    
    @Column(name = "fecha_restock")
    private Date fechaRestock;
    
    private transient List<Editorial> editoriales;
}
