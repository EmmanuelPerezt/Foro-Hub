package com.forohub.api.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "respuesta")
@NoArgsConstructor
@Data
public class Respuesta {


    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;


    String mensaje;

    @ManyToOne
    @JoinColumn(name = "id_topico")
    private Topico topico;

    LocalDateTime fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Usuario autor;
    
    



}
