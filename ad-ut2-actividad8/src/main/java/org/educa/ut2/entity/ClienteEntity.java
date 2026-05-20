package org.educa.ut2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteEntity {
    private Integer idCliente;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String email;
    private String dni;
    private String telefono;
    private Integer numAlquileres;
}
