package com.proyecto.controller;

import com.proyecto.model.Editorial;
import com.proyecto.service.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EditorialController {

    @Autowired
    private EditorialService editorialService;

    @GetMapping("/editoriales")
    public List<Editorial> listarTodos() {
        return editorialService.listarTodos();
    }

    @GetMapping("/editoriales/{id}")
    public Editorial obtenerPorId(@PathVariable Long id) {
        return editorialService.obtenerPorId(id);
    }

    @GetMapping("/editoriales/libro/{idLibro}")
    public List<Editorial> listarPorIdLibro(@PathVariable Long idLibro) {
        return editorialService.listarPorIdLibro(idLibro);
    }

    @PostMapping("/editoriales")
    public Editorial registrarEditorial(@RequestBody Editorial editorial) {
        return editorialService.registrarEditorial(editorial);
    }

    @PutMapping("/editoriales/{id}")
    public Editorial actualizarEditorial(@PathVariable Long id, @RequestBody Editorial editorial) {
        editorial.setId(id);
        return editorialService.actualizarEditorial(editorial);
    }

    @DeleteMapping("/editoriales/{id}")
    public void eliminarEditorial(@PathVariable Long id) {
        editorialService.eliminarEditorial(id);
    }
}
