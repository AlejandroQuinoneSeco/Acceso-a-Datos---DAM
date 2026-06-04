package org.educa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sucursal")
public class SucursalEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sucursal")
    private Integer idSucursal;
    @Column(name = "calle")
    private String calle;
    @Column(name = "ciudad")
    private String ciudad;
    @Column(name = "pais")
    private String pais;
    @Column(name = "c_p")
    private String cp;

    @OneToMany(mappedBy = "sucursal", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<VehiculoEntity> vehiculos;

}
