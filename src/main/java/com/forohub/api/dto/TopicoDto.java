package com.forohub.api.dto;



import com.forohub.api.model.Curso;
import com.forohub.api.model.Usuario;

public record TopicoDto(String titulo, String mensaje, String status, Usuario autor, Curso curso) {
}
