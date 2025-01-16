package com.forohub.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioDto(
    @NotBlank(message = "El nombre es requerido")
    String nombre, 
    @NotBlank(message = "El correo es requerido")
    @Email(message = "El correo no es válido")
    String correo,
    @NotBlank(message = "La contraseña es requerida")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres") 
    String password
    ) {}
