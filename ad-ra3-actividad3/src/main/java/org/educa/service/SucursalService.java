package org.educa.service;

import org.educa.dao.SucursalDAO;
import org.educa.dao.SucursalDAOImpl;
import org.educa.entity.SucursalEntity;

public class SucursalService {

    private final SucursalDAO sucursalDAO = new SucursalDAOImpl();

    public void save(SucursalEntity sucursalEntity) {
        sucursalDAO.save(sucursalEntity);
    }
}
