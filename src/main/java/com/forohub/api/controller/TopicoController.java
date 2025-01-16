package com.forohub.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forohub.api.dto.TopicoDto;
import com.forohub.api.service.TopicoService;

@RestController
@RequestMapping("/api/topico")
public class TopicoController {


    @Autowired
    private TopicoService topicoService;

    @PostMapping
    public ResponseEntity<TopicoDto> crearTopico(@RequestBody TopicoDto topicoDto) {

        topicoService.crearTopico(topicoDto);
        
        return ResponseEntity.ok(topicoDto);
    }
    
}
