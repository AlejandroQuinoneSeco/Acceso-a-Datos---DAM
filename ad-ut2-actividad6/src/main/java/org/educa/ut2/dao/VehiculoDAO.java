package org.educa.ut2.dao;

import org.educa.ut2.entity.VehiculoEntity;

public interface VehiculoDAO {
    VehiculoEntity findByBastidor(String bastidor);
}
