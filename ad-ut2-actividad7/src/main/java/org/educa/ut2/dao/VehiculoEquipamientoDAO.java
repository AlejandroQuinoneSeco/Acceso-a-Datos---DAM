package org.educa.ut2.dao;

import org.educa.ut2.entity.VehiculoEntity;

import java.sql.Connection;
import java.sql.SQLException;

public interface VehiculoEquipamientoDAO {
    /**
     * Inserta la relación entre vehículos y equipamiento
     *
     * @param conn     Connection
     * @param vehiculo el vehiculo con la lista de equipamientos incluidos
     */
    void insertVehiculoEquipamiento(Connection conn, VehiculoEntity vehiculo) throws SQLException;
}
