package com.proyecto.service;

import com.proyecto.editorial.Editorial;
import com.proyecto.editorial.LibroEditorial;
import com.proyecto.model.Libro;
import com.proyecto.repository.ILibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {
	
	@Autowired
    private LibroEditorial editorialClient;

    @Autowired
    private ILibroRepository libroRepository;

    public List<Libro> listarTodos() {
        return libroRepository.findAll();
    }

    public Libro obtenerPorId(Long id) {
        Optional<Libro> optionalLibro = libroRepository.findById(id);
        return optionalLibro.orElse(null);
    }

    public Libro registrarLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    public Libro actualizarLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    public void eliminarLibro(Long id) {
        libroRepository.deleteById(id);
    }
    
    public Libro obtenerLibroConEditoriales(Long id) {
        Optional<Libro> optionalLibro = libroRepository.findById(id);
        if (optionalLibro.isPresent()) {
            Libro libro = optionalLibro.get();
            List<Editorial> editoriales = editorialClient.listarEditorialesPorIdLibro(libro.getId());
            libro.setEditoriales(editoriales);
            return libro;
        }
        return null;
    }
}
