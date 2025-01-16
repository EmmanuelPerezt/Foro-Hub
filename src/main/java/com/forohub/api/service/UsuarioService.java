package com.forohub.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forohub.api.model.Usuario;
import com.forohub.api.repository.UsuarioRepository;

@Service
public class UsuarioService {
    

    @Autowired
    private UsuarioRepository usuarioRepository;


    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    public Usuario buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }
    public Usuario actualizarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
    public boolean validarCorreo(String correo) {
        return usuarioRepository.existsByCorreo(correo);
    }
}
