package org.educa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VideojuegosWithRelations implements Serializable {
    private Integer id;
    private String titulo;
    private Estudios estudio;
    private Boolean disponible;
    private List<Generos> generos;
}
