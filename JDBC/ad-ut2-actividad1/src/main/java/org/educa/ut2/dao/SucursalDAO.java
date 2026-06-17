package org.educa.ut2.dao;

import org.educa.ut2.entity.SucursalEntity;

public interface SucursalDAO {

    /**
     * Encuentra la Sucursal por calle y ciudad
     *
     * @param calle  La calle
     * @param ciudad La ciudad
     * @return La sucursal {@link SucursalEntity}
     */
    SucursalEntity findByCalleYCiudad(String calle, String ciudad);
}
