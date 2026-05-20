package org.educa.ut2.service;

import org.educa.ut2.dao.EquipamientoDAO;
import org.educa.ut2.dao.EquipamientoDAOImpl;
import org.educa.ut2.entity.EquipamientoEntity;

import java.util.List;

public class EquipamientoService {
    private final EquipamientoDAO equipamientoDAO = new EquipamientoDAOImpl();

    /**
     * Encuentra todos los equipamientos disponibles
     *
     * @return Lista de {@link EquipamientoEntity} con todos los equipamientos
     */
    public List<EquipamientoEntity> findAll() {
        return equipamientoDAO.findAllEquipamientos();
    }


}
