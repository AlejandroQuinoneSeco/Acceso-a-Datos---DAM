package org.educa.ut2.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class AlquilerEntity {
    private Integer idAlquiler;
    private LocalDate fechaIni;
    private LocalDate fechaFin;
    private ClienteEntity cliente;
    private VehiculoEntity vehiculo;
    private Integer idSeguro;
    private BigDecimal precio;
}
