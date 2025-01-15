package com.forohub.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.forohub.api.model.Topico;


@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
    
}
