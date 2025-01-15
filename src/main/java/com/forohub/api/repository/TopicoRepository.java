package com.forohub.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forohub.api.model.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    
}
