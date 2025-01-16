package com.forohub.api.model;

import java.time.LocalDateTime;
import java.util.List;

import com.forohub.api.dto.TopicoDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "topico")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    String titulo;
    String mensaje;
    LocalDateTime fechaCreacion;
    String status;
    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Usuario autor;


    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Curso curso;




    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL)
    private List<Respuesta> respuestas;



    public Topico(TopicoDto topicoDto) {
        this.titulo = topicoDto.titulo();
        this.mensaje = topicoDto.mensaje();
        this.status = topicoDto.status();
        this.autor = topicoDto.autor();
        this.curso = topicoDto.curso();

    }
}
