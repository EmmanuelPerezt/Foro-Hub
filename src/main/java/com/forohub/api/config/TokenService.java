package com.forohub.api.config;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.forohub.api.model.Usuario;

@Service
public class TokenService {

    public String generarToken(Usuario usuario) {

        try {
            Algorithm algorithm = Algorithm.HMAC256("12345678");
            String token = JWT.create()
                    .withIssuer("forohub")
                    .withSubject(usuario.getUsername())
                    .withClaim("id", usuario.getId())
                    .withExpiresAt(fechaExpiracion())
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error al crear token");
        }
    }

    private Instant fechaExpiracion() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-05:00"));
    }

}
