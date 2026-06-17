package org.educa.ut2.dao;

import org.educa.ut2.entity.VehiculoEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface VehiculoDAO {
    /**
     * Inserta todos los Vehiculos pasados por parámetro. Al finalizar cada Vehículo de la lista
     * contendrá el id que se ha autogenerado en la BBDD.
     *
     * @param conn
     * @param vehiculoEntities Lista de {@link VehiculoEntity}
     */
    void insertAll(Connection conn, List<VehiculoEntity> vehiculoEntities) throws SQLException;

}
