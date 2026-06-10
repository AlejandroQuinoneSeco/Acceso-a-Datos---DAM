package org.educa.ut5.entity;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LibroEntity implements Serializable {

    @SerializedName("_id")
    private Integer id;
    @SerializedName("titulo")
    private String titulo;
    @SerializedName("autor")
    private AutorEntity autor;
    @SerializedName("categoria_id")
    private Integer categoriaId;
    @SerializedName("disponible")
    private String disponible;
}
