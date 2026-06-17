package org.educa.ut2.service;

import org.educa.ut2.dao.CombustibleDAO;
import org.educa.ut2.dao.CombustibleDAOImpl;
import org.educa.ut2.entity.CombustibleEntity;

public class CombustibleService {
    private final CombustibleDAO combustibleDAO = new CombustibleDAOImpl();

    /**
     * Devuelve el id del nombre del combustible pasado por parámetro
     *
     * @param nombre nombre del combustible
     * @return El id del combustible
     */
    public Integer findIdByNombre(String nombre) {
        CombustibleEntity combustibleEntity = combustibleDAO.findByNombre(nombre);
        return combustibleEntity.getId();
    }
}
