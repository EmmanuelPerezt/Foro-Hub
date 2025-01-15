package com.forohub.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.forohub.api.model.Curso;


@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    Curso findByNome(String nome);
    
}
