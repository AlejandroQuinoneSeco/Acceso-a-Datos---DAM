package org.educa.ut2.dao;

import org.educa.ut2.entity.EquipamientoEntity;

import java.util.List;

public interface EquipamientoDAO {

    /**
     * Encuentra todos los EquipamientoEntity
     *
     * @return La lista con todos los {@link EquipamientoEntity}
     */
    List<EquipamientoEntity> findAllEquipamientos();

}
