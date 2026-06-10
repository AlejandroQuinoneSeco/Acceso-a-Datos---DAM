package org.educa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Videojuegos implements Serializable {
    private Integer id;
    private String titulo;
    private Integer estudio;
    private List<Integer> generos;
}
