package com.proyecto.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.proyecto.models.Libro;

import java.util.List;

@FeignClient(name = "libro-service", url = "http://localhost:8083/api")
public interface LibroFeignClient {

    @GetMapping("/libros")
    List<Libro> listarTodos();

    @GetMapping("/libros/{id}")
    Libro obtenerPorId(@PathVariable Long id);

    @PostMapping("/libros")
    Libro registrarLibro(@RequestBody Libro libro);

    @PutMapping("/libros/{id}")
    Libro actualizarLibro(@PathVariable Long id, @RequestBody Libro libro);

    @DeleteMapping("/libros/{id}")
    void eliminarLibro(@PathVariable Long id);

    @GetMapping("/libroEditorial/{id}")
    Libro obtenerLibroConEditoriales(@PathVariable Long id);
}

