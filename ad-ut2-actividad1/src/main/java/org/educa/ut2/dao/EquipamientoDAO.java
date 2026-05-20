package org.educa.ut2.dao;

import org.educa.ut2.entity.EquipamientoEntity;

import java.util.List;

public interface EquipamientoDAO {
    /**
     * Encuentra una lista de EquipamientoEntity en base a un array de String
     *
     * @param equipamientos el array de String con los equipamientos
     * @return La lista de {@link EquipamientoEntity}
     */
    List<EquipamientoEntity> findListaEquipamientos(String[] equipamientos);

    /**
     * Encuentra todos los EquipamientoEntity
     *
     * @return La lista con todos los {@link EquipamientoEntity}
     */
    List<EquipamientoEntity> findAllEquipamientos();

}
