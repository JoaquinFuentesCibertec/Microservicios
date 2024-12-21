package com.proyecto.service;

import com.proyecto.model.Editorial;
import com.proyecto.repository.IEditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EditorialService {

    @Autowired
    private IEditorialRepository editorialRepository;

    public List<Editorial> listarTodos() {
        return editorialRepository.findAll();
    }

    public Editorial obtenerPorId(Long id) {
        Optional<Editorial> optionalEditorial = editorialRepository.findById(id);
        return optionalEditorial.orElse(null);
    }

    public List<Editorial> listarPorIdLibro(Long idLibro) {
        return editorialRepository.findByIdLibro(idLibro);
    }

    public Editorial registrarEditorial(Editorial editorial) {
        return editorialRepository.save(editorial);
    }

    public Editorial actualizarEditorial(Editorial editorial) {
        return editorialRepository.save(editorial);
    }

    public void eliminarEditorial(Long id) {
        editorialRepository.deleteById(id);
    }
}