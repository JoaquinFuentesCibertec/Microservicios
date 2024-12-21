package com.proyecto.editorial;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "editorial-service", url = "http://localhost:8084/api")
public interface LibroEditorial {

    @GetMapping("/editoriales/libro/{idLibro}")
    List<Editorial> listarEditorialesPorIdLibro(@PathVariable("idLibro") Long idLibro);
}

