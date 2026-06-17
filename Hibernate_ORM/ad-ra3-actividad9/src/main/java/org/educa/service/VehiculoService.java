package org.educa.service;

import org.educa.dao.VehiculoDAO;
import org.educa.dao.VehiculoDAOImpl;
import org.educa.entity.VehiculoEntity;

public class VehiculoService {
    private final VehiculoDAO vehiculoDAO = new VehiculoDAOImpl();

    public void save(VehiculoEntity vehiculoEntity) {
        vehiculoDAO.save(vehiculoEntity);
    }
}
