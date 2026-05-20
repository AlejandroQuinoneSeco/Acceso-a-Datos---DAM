package org.educa.ut2.service;

import org.educa.ut2.dao.SucursalDAO;
import org.educa.ut2.dao.SucursalDAOImpl;
import org.educa.ut2.entity.SucursalEntity;

import java.util.List;

public class SucursalService {
    private final SucursalDAO sucursalDAO = new SucursalDAOImpl();

    public List<SucursalEntity> findAll() {
        return sucursalDAO.findAll();
    }
}
