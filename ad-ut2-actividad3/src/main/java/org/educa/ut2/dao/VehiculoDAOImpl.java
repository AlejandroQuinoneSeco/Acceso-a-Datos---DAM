package org.educa.ut2.dao;

import org.educa.ut2.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VehiculoDAOImpl implements VehiculoDAO {

    @Override
    public void deleteAllVehiculoBefore(int year) {
        String sql = "DELETE FROM vehiculo WHERE anio < ?";
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, year);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
