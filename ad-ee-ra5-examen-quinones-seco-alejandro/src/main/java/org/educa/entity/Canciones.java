package org.educa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Canciones implements Serializable {

    private Integer id;

    private String titulo;

    private Integer director;

    private List<Integer> generos;
}
