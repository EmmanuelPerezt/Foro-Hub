package com.forohub.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forohub.api.model.Respuesta;
import com.forohub.api.repository.RespuestaRepository;

@Service
public class RespuestaService {
    



    @Autowired
    private RespuestaRepository respuestaRepository;



    public Respuesta crearRespuesta(Respuesta respuesta) {
        return respuestaRepository.save(respuesta);
    }
    public Respuesta buscarRespuestaPorId(Long id) {
        return respuestaRepository.findById(id).orElse(null);
    }
    public Respuesta actualizarRespuesta(Respuesta respuesta) {
        return respuestaRepository.save(respuesta);
    }
    public void eliminarRespuesta(Long id) {
        respuestaRepository.deleteById(id);
    }
}
