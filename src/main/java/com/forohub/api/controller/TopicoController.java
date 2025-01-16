package com.forohub.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forohub.api.dto.TopicoDto;
import com.forohub.api.dto.TopicoResponseDto;
import com.forohub.api.model.Topico;
import com.forohub.api.service.TopicoService;

import jakarta.validation.Valid;

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
    @GetMapping("/{id}")
    public ResponseEntity<TopicoResponseDto> obtenerTopicoPorId(@PathVariable Long id){
        return ResponseEntity.ok(topicoService.buscarTopicoPorId(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<TopicoResponseDto> actualizarTopico(@PathVariable Long id, @RequestBody @Valid TopicoDto topicoDto){
        topicoService.buscarTopicoPorId(id);
        Topico topicoActualizado = new Topico(topicoDto);
        topicoActualizado.setId(id);
        topicoService.actualizarTopico(topicoActualizado);
        return ResponseEntity.ok(new TopicoResponseDto(topicoDto.titulo(), topicoDto.mensaje(), topicoDto.status(), topicoDto.curso()));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id){
        topicoService.eliminarTopico(id);
        return ResponseEntity.noContent().build();
    }

    
}
