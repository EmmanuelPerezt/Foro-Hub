package com.forohub.api.dto;

import com.forohub.api.model.Curso;
import com.forohub.api.model.Topico;


public record TopicoResponseDto(String titulo, String mensaje, String status, Curso curso) {

     public TopicoResponseDto(Topico topico){
        this(topico.getTitulo(), topico.getMensaje(), topico.getStatus(), topico.getCurso());
    }
}
