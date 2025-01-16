package com.forohub.api.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forohub.api.dto.TopicoDto;
import com.forohub.api.dto.TopicoResponseDto;
import com.forohub.api.model.Topico;
import com.forohub.api.repository.TopicoRepository;

@Service
public class TopicoService {
    
    @Autowired
    private TopicoRepository topicoRepository;





    public Topico crearTopico(TopicoDto topicoDto) {
        Topico topico = new Topico(topicoDto);
        topico.setFechaCreacion(LocalDateTime.now());
        return topicoRepository.save(topico);
    }
    public Topico buscarTopicoPorId(Long id) {
        return topicoRepository.findById(id).orElse(null);
    }
    public Topico actualizarTopico(Topico topico) {
        return topicoRepository.save(topico);
    }
    public void eliminarTopico(Long id) {
        topicoRepository.deleteById(id);
    }
    public List<TopicoResponseDto> obtenerTodoslosTopicos() {
        List<Topico>topicos = topicoRepository.findAll();
        List<TopicoResponseDto> topicoDto = topicos.stream().map(TopicoResponseDto::new).toList();
        return topicoDto;
    }
}
