package org.educa.ut2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoEntity {
    private Integer id;
    private String matricula;
    private String bastidor;
    private String marca;
    private String modelo;
    private String color;
    private Integer anyo;
    private Integer categoria;
    private Integer sucursal;
    private Integer combustible;
}
