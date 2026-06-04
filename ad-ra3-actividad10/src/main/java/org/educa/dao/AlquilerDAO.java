package org.educa.dao;

import org.educa.entity.AlquilerEntity;

import java.util.List;

public interface AlquilerDAO {
    List<AlquilerEntity> findAlquileresByMarcaAndModelo(String marca, String modelo);

    void update(List<AlquilerEntity> alquileres);
}
