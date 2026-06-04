package org.educa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeguroEntity {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nombre;
    private String descripcion;
    private List<AlquilerEntity> alquileres = new ArrayList<>();
}

