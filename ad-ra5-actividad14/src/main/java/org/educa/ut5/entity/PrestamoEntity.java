package org.educa.ut5.entity;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrestamoEntity implements Serializable {

    @SerializedName("_id")
    private Integer id;
    @SerializedName("usuario")
    private UsuarioEntity usuario;
    @SerializedName("libro_id")
    private Integer libroId;
    @SerializedName("fecha_inicio")
    private String fechaInicio;
    @SerializedName("fecha_fin")
    private String fechaFin;
}
