package org.educa.ut2.dao;

import org.educa.ut2.entity.CombustibleEntity;
import org.educa.ut2.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CombustibleDAOImpl implements CombustibleDAO {

    @Override
    public CombustibleEntity findByNombre(String nombre) {
        String sql = "SELECT * FROM combustible WHERE nombre = ?";
        CombustibleEntity combustibleEntity = new CombustibleEntity();
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, nombre);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    combustibleEntity.setId(rs.getInt(1));
                    combustibleEntity.setNombre(rs.getString(2));
                    combustibleEntity.setDescripcion(rs.getString(3));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return combustibleEntity;
    }
}
