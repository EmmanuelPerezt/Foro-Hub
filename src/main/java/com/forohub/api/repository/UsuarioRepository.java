package com.forohub.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forohub.api.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
    
}
