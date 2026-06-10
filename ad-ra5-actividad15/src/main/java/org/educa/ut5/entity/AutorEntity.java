package org.educa.ut5.entity;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutorEntity implements Serializable {
    @SerializedName("_id")
    private Integer id;
    @SerializedName("nombre")
    private String nombre;
    @SerializedName("nacionalidad")
    private String nacionalidad;
}
