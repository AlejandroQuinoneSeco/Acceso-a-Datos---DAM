package org.educa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehiculoEntity {
    private Integer id;

    private String matricula;

    private String bastidor;

    private String marca;

    private String modelo;

    private String color;

    private Integer anio;

    private SucursalEntity sucursal;

}