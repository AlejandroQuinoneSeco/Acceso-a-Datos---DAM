package org.educa.ut2.service;

import org.educa.ut2.dao.VehiculoDAO;
import org.educa.ut2.dao.VehiculoDAOImpl;
import org.educa.ut2.entity.VehiculoEntity;
import org.educa.ut2.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;

public class VehiculoService {
    private final VehiculoDAO vehiculoDAO = new VehiculoDAOImpl();

    private final VehiculoEquipamientoService vehiculoEquipamientoService = new VehiculoEquipamientoService();


    public void insert(VehiculoEntity vehiculo) {
        try (Connection conn = ConnectionPool.getDataSource().getConnection()) {
            conn.setAutoCommit(false);
            vehiculoDAO.insert(conn, vehiculo);
            vehiculoEquipamientoService.insertVehiculoEquipamiento(conn, vehiculo);
            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
