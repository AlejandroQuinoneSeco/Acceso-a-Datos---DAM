package org.educa.ut2.dao;

import org.educa.ut2.entity.CombustibleEntity;

public interface CombustibleDAO {
    /**
     * Encuentra un Combustible por nombre
     *
     * @param nombre Nombre del combustible
     * @return El combustible {@link CombustibleEntity}
     */
    CombustibleEntity findByNombre(String nombre);
}
