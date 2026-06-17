package org.educa.ut2.service;

import org.educa.ut2.dao.VehiculoDAO;
import org.educa.ut2.dao.VehiculoDAOImpl;
import org.educa.ut2.entity.VehiculoEntity;

public class VehiculoService {
    private final VehiculoDAO vehiculoDAO = new VehiculoDAOImpl();

    public VehiculoEntity findByBastidor(String bastidor) {
        return vehiculoDAO.findByBastidor(bastidor);
    }
}
