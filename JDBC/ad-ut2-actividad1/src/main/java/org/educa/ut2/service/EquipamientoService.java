package org.educa.ut2.service;

import org.educa.ut2.dao.EquipamientoDAO;
import org.educa.ut2.dao.EquipamientoDAOImpl;
import org.educa.ut2.entity.EquipamientoEntity;

import java.util.List;

public class EquipamientoService {
    private final EquipamientoDAO equipamientoDAO = new EquipamientoDAOImpl();

    /**
     * Encuentra la lista de {@link EquipamientoEntity} para los nombres de equipamientos pasados como parámetros
     *
     * @param equipamientos El array de equipamientos
     * @return la lista de {@link EquipamientoEntity}
     */
    public List<EquipamientoEntity> findListaEquipamientos(String... equipamientos) {
        return equipamientoDAO.findListaEquipamientos(equipamientos);
    }

    /**
     * Encuentra todos los equipamientos disponibles
     *
     * @return Lista de {@link EquipamientoEntity} con todos los equipamientos
     */
    public List<EquipamientoEntity> findAllEquipamientos() {
        return equipamientoDAO.findAllEquipamientos();
    }
}
