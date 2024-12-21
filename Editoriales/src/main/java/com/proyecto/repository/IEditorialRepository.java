package com.proyecto.repository;

import com.proyecto.model.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEditorialRepository extends JpaRepository<Editorial, Long> {
    List<Editorial> findByIdLibro(Long idLibro);
}
