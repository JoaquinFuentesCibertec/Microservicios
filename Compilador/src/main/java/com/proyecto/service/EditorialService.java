package com.proyecto.service;

import com.proyecto.FeignClient.EditorialFeignClient;
import com.proyecto.models.Editorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditorialService {

    @Autowired
    private EditorialFeignClient editorialFeignClient;

    public List<Editorial> listarTodos() {
        return editorialFeignClient.listarTodos();
    }

    public Editorial obtenerPorId(Long id) {
        return editorialFeignClient.obtenerPorId(id);
    }

    public List<Editorial> listarPorIdLibro(Long idLibro) {
        return editorialFeignClient.listarPorIdLibro(idLibro);
    }

    public Editorial registrarEditorial(Editorial editorial) {
        return editorialFeignClient.registrarEditorial(editorial);
    }

    public Editorial actualizarEditorial(Long id, Editorial editorial) {
        return editorialFeignClient.actualizarEditorial(id, editorial);
    }

    public void eliminarEditorial(Long id) {
        editorialFeignClient.eliminarEditorial(id);
    }
}
