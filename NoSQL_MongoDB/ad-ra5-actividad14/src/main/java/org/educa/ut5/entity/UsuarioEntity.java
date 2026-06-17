package org.educa.ut5.entity;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEntity implements Serializable {

    @SerializedName("_id")
    private Integer id;
    private String nombre;
    private String email;
    private String telefono;
    private Boolean activo;
}
