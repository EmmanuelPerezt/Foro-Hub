package com.forohub.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.forohub.api.model.Respuesta;


@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta, Long>{
    
}
