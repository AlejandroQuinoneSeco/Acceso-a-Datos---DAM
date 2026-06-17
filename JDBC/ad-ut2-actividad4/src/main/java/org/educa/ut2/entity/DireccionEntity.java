package org.educa.ut2.entity;

import lombok.Data;

@Data
public class DireccionEntity {
    private Integer idDireccion;
    private String calle;
    private String ciudad;
    private String pais;
    private String cp;
    private Integer idCliente;
}
