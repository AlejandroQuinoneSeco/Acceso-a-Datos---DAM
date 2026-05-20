package org.educa.ut2.service;

import org.educa.ut2.dao.VehiculoDAO;
import org.educa.ut2.dao.VehiculoDAOImpl;

public class VehiculoService {
    private final VehiculoDAO vehiculoDAO = new VehiculoDAOImpl();

    public void deleteAllVehiculoBefore(int year) {
        vehiculoDAO.deleteAllVehiculoBefore(year);
    }
}
