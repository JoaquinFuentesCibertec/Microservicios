package com.proyecto.service;

import com.proyecto.FeignClient.LibroFeignClient;
import com.proyecto.models.Libro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    @Autowired
    private LibroFeignClient libroFeignClient;

    public List<Libro> listarTodos() {
        return libroFeignClient.listarTodos();
    }

    public Libro obtenerPorId(Long id) {
        return libroFeignClient.obtenerPorId(id);
    }

    public Libro registrarLibro(Libro libro) {
        return libroFeignClient.registrarLibro(libro);
    }

    public Libro actualizarLibro(Long id, Libro libro) {
        return libroFeignClient.actualizarLibro(id, libro);
    }

    public void eliminarLibro(Long id) {
        libroFeignClient.eliminarLibro(id);
    }

    public Libro obtenerLibroConEditoriales(Long id) {
        return libroFeignClient.obtenerLibroConEditoriales(id);
    }
}
