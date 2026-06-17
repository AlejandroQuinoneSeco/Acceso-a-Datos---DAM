package org.educa.ut2.dao;

import org.educa.ut2.entity.AlquilerEntity;

import java.util.List;

public interface AlquilerDAO {

    List<AlquilerEntity> findByPrecioInferior(double precio);
}
