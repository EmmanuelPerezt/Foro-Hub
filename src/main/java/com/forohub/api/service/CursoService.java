package com.forohub.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forohub.api.model.Curso;
import com.forohub.api.repository.CursoRepository;

@Service
public class CursoService {
    


    @Autowired
    private CursoRepository cursoRepository;

    public Curso crearCurso(Curso curso) {
        return cursoRepository.save(curso);
    }
    public Curso buscarCursoPorId(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }
    public Curso actualizarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }
    public void eliminarCurso(Long id) {
        cursoRepository.deleteById(id);
    }
}
