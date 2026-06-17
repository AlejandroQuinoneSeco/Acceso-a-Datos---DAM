package org.educa.ut2.service;

import org.educa.ut2.dao.VehiculoDAO;
import org.educa.ut2.dao.VehiculoDAOImpl;
import org.educa.ut2.entity.VehiculoEntity;
import org.educa.ut2.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class VehiculoService {
    private final VehiculoDAO vehiculoDAO = new VehiculoDAOImpl();

    private final VehiculoEquipamientoService vehiculoEquipamientoService = new VehiculoEquipamientoService();

    /**
     * Guarda todos los vehículos pasados como parámetro. Al finalizar cada Vehículo de la lista
     * contendrá el id que se ha autogenerado en la BBDD
     *
     * @param vehiculoEntities la lista de {@link VehiculoEntity}
     */
    public void insertAll(List<VehiculoEntity> vehiculoEntities) {
        try(Connection conn = ConnectionPool.getDataSource().getConnection()) {
            conn.setAutoCommit(false);
            vehiculoDAO.insertAll(conn, vehiculoEntities);
            vehiculoEquipamientoService.insertVehiculoEquipamiento(conn, vehiculoEntities);
            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
