package org.educa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoEntity {
    private Integer id;
    private String matricula;
    private String bastidor;
    private CombustibleEntity combustible;
}

