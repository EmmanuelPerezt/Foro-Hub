package com.forohub.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forohub.api.model.Topico;
import com.forohub.api.repository.TopicoRepository;

@Service
public class TopicoService {
    
    @Autowired
    private TopicoRepository topicoRepository;





    public Topico crearTopico(Topico topico) {
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
}
