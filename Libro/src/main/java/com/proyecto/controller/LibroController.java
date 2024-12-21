package com.proyecto.controller;

import com.proyecto.model.Libro;
import com.proyecto.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping("/libros")
    public List<Libro> listarTodos() {
        return libroService.listarTodos();
    }

    @GetMapping("/libros/{id}")
    public Libro obtenerPorId(@PathVariable Long id) {
        return libroService.obtenerPorId(id);
    }

    @PostMapping("/libros")
    public Libro registrarLibro(@RequestBody Libro libro) {
        return libroService.registrarLibro(libro);
    }

    @PutMapping("/libros/{id}")
    public Libro actualizarLibro(@PathVariable Long id, @RequestBody Libro libro) {
        libro.setId(id);
        return libroService.actualizarLibro(libro);
    }

    @DeleteMapping("/libros/{id}")
    public void eliminarLibro(@PathVariable Long id) {
        libroService.eliminarLibro(id);
    }
    
    @GetMapping("/libroEditorial/{id}")
    public Libro obtenerLibroConEditoriales(@PathVariable Long id) {
        return libroService.obtenerLibroConEditoriales(id);
    }
}
