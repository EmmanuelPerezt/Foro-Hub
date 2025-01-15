package com.forohub.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forohub.api.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    Curso findByNome(String nome);
    
}
