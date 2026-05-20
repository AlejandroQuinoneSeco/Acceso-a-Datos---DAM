package org.educa.ut2.dao;

import org.educa.ut2.entity.EquipamientoEntity;
import org.educa.ut2.entity.VehiculoEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VehiculoEquipamientoDAOImpl implements VehiculoEquipamientoDAO {
    @Override
    public void insertVehiculoEquipamiento(Connection conn, VehiculoEntity vehiculo) throws SQLException {
        try {
            for (EquipamientoEntity equipamiento : vehiculo.getEquipamiento()) {
                insertVehiculoEquipamiento(conn, vehiculo, equipamiento);
            }
        } catch (Exception e) {
            conn.rollback();
            throw new RuntimeException(e);
        }
    }

    private void insertVehiculoEquipamiento(Connection connection, VehiculoEntity vehiculo, EquipamientoEntity equipamiento) {
        String sql = "INSERT INTO vehiculo_equipamiento (id_vehiculo, id_equip) VALUES (?,?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, vehiculo.getId());
            ps.setInt(2, equipamiento.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
