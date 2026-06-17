package org.educa.ut2.entity;

import lombok.Data;

@Data
public class SucursalEntity {
    private Integer id;
    private String calle;
    private String ciudad;
    private String pais;
    private String cp;
}
