package com.forohub.api.dto;



import com.forohub.api.model.Curso;
import com.forohub.api.model.Topico;
import com.forohub.api.model.Usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicoDto(
    @NotBlank
    String titulo, 
    @NotBlank
    String mensaje, 
    @NotBlank
    String status, 
    @NotNull
    Usuario autor, 
    @NotNull
    Curso curso) {



    public TopicoDto(Topico topico){
        this(topico.getTitulo(), topico.getMensaje(), topico.getStatus(), topico.getAutor(), topico.getCurso());
    }
}
