package org.educa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlquilerEntity {
    private Integer id;
    private LocalDate fechaIni;
    private LocalDate fechaFin;
    private BigDecimal precio;
    private SeguroEntity seguro;
}

