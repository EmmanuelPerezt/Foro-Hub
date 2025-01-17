package com.forohub.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forohub.api.config.TokenService;
import com.forohub.api.dto.JwtDto;
import com.forohub.api.dto.UsuarioDto;
import com.forohub.api.model.Usuario;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class Login {
    


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<JwtDto>login(@RequestBody @Valid UsuarioDto usuarioDto){
        Authentication token = new UsernamePasswordAuthenticationToken(usuarioDto.username(), usuarioDto.password());
        var usuarioAutenticado = authenticationManager.authenticate(token);
        String tokenJwt =tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());

        return ResponseEntity.ok(new JwtDto(tokenJwt));
    }
}