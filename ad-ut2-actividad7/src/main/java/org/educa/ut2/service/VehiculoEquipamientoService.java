package org.educa.ut2.service;

import org.educa.ut2.dao.VehiculoEquipamientoDAO;
import org.educa.ut2.dao.VehiculoEquipamientoDAOImpl;
import org.educa.ut2.entity.VehiculoEntity;

import java.sql.Connection;
import java.sql.SQLException;

public class VehiculoEquipamientoService {
    private final VehiculoEquipamientoDAO vehiculoEquipamientoDAO = new VehiculoEquipamientoDAOImpl();

    /**
     * Guarda la relación entre Vehículos y equipamiento para la lista de vehículos pasado por parámetro.
     *
     * @param conn     Connection
     * @param vehiculo vehiculo {@link VehiculoEntity}
     */
    public void insertVehiculoEquipamiento(Connection conn, VehiculoEntity vehiculo) throws SQLException {
        vehiculoEquipamientoDAO.insertVehiculoEquipamiento(conn, vehiculo);
    }
}
