package org.educa.ut5.entity;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrestamoEntity implements Serializable {

    @SerializedName("_id")
    private Integer  id;
    @SerializedName("usuario_id")
    private Integer  usuarioId;
    @SerializedName("libro_id")
    private Integer libroId;
    @SerializedName("fecha_inicio")
    private LocalDate fechaInicio;
    @SerializedName("fecha_fin")
    private LocalDate fechaFin;
}
