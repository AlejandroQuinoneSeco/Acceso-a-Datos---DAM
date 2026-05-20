package org.educa.ut2.dao;

import org.educa.ut2.entity.VehiculoEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface VehiculoEquipamientoDAO {
    /**
     * Inserta la relación entre vehículos y equipamiento
     *
     * @param conn
     * @param vehiculos la lista de vehículos con los equipamientos incluidos
     */
    void insertVehiculoEquipamiento(Connection conn, List<VehiculoEntity> vehiculos) throws SQLException;
}
