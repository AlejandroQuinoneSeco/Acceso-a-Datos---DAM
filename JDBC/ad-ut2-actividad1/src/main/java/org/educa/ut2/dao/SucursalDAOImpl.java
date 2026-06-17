package org.educa.ut2.dao;

import org.educa.ut2.entity.SucursalEntity;
import org.educa.ut2.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SucursalDAOImpl implements SucursalDAO {

    @Override
    public SucursalEntity findByCalleYCiudad(String calle, String ciudad) {
        String sql = "SELECT * FROM sucursal WHERE calle = ? AND ciudad = ?";
        SucursalEntity sucursal = new SucursalEntity();
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, calle);
            ps.setString(2, ciudad);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    sucursal.setId(rs.getInt(1));
                    sucursal.setCalle(rs.getString(2));
                    sucursal.setCiudad(rs.getString(3));
                    sucursal.setPais(rs.getString(4));
                    sucursal.setCp(rs.getString(5));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sucursal;
    }
}
