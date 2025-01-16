package com.forohub.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forohub.api.dto.UsuarioDto;
import com.forohub.api.dto.UsuarioresponseDto;
import com.forohub.api.model.Usuario;
import com.forohub.api.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;


    @Autowired
    private AuthenticationManager authenticationManager;



    @PostMapping
    public ResponseEntity<UsuarioresponseDto> crearUsuario(@RequestBody @Valid UsuarioDto usuarioDto) {
        //validar que el correo no exista
        if (usuarioService.validarCorreo(usuarioDto.correo())) {
            return ResponseEntity.badRequest().body(new UsuarioresponseDto(null, null ,"Correo ya registrado"));
        }
        Usuario usuario = new Usuario();
        usuario.setUsername(usuarioDto.nombre());
        usuario.setCorreo(usuarioDto.correo());
        usuario.setPassword(usuarioDto.password());
        usuario = usuarioService.crearUsuario(usuario);
        var usuarioresponseDto = new UsuarioresponseDto(usuario.getUsername(), usuario.getCorreo(),"Usuario creado");
        return ResponseEntity.ok(usuarioresponseDto);
    }
}