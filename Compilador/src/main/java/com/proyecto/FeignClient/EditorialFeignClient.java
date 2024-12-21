package com.proyecto.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.proyecto.models.Editorial;

import java.util.List;

@FeignClient(name = "editorial-service", url = "http://localhost:8084/api")
public interface EditorialFeignClient {

    @GetMapping("/editoriales")
    List<Editorial> listarTodos();

    @GetMapping("/editoriales/{id}")
    Editorial obtenerPorId(@PathVariable Long id);

    @GetMapping("/editoriales/libro/{idLibro}")
    List<Editorial> listarPorIdLibro(@PathVariable Long idLibro);

    @PostMapping("/editoriales")
    Editorial registrarEditorial(@RequestBody Editorial editorial);

    @PutMapping("/editoriales/{id}")
    Editorial actualizarEditorial(@PathVariable Long id, @RequestBody Editorial editorial);

    @DeleteMapping("/editoriales/{id}")
    void eliminarEditorial(@PathVariable Long id);
}

