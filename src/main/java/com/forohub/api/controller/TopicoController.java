package com.forohub.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forohub.api.dto.TopicoDto;
import com.forohub.api.dto.TopicoResponseDto;
import com.forohub.api.service.TopicoService;

@RestController
@RequestMapping("/api/topico")
public class TopicoController {


    @Autowired
    private TopicoService topicoService;

    @PostMapping
    public ResponseEntity<TopicoResponseDto> crearTopico(@RequestBody TopicoDto topicoDto) {

        topicoService.crearTopico(topicoDto);
        var topicoResponseDto = new TopicoResponseDto(topicoDto.titulo(), topicoDto.mensaje(), topicoDto.status(), topicoDto.curso());
        return ResponseEntity.ok(topicoResponseDto);
    }
    @GetMapping
    public ResponseEntity<List<TopicoResponseDto>> obtenerTodoslosTopicos(){
        return ResponseEntity.ok(topicoService.obtenerTodoslosTopicos());
    }
    
}
