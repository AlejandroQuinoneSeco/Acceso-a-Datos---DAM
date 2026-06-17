package org.educa.ut2.service;

import org.educa.ut2.dao.SucursalDAO;
import org.educa.ut2.dao.SucursalDAOImpl;
import org.educa.ut2.entity.SucursalEntity;

public class SucursalService {
    private final SucursalDAO sucursalDAO = new SucursalDAOImpl();

    /**
     * Devuelve el id de la sucursal para la calle y la ciudad
     *
     * @param calle  La calle
     * @param ciudad La ciudad
     * @return El id de sucursal
     */
    public Integer findIdByCalleYCiudad(String calle, String ciudad) {
        SucursalEntity sucursal = sucursalDAO.findByCalleYCiudad(calle, ciudad);
        return sucursal.getId();
    }
}
