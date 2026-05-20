package org.educa.ut2.dao;

import org.educa.ut2.entity.SucursalEntity;
import org.educa.ut2.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SucursalDAOImpl implements SucursalDAO {

    @Override
    public List<SucursalEntity> findAll() {
        String sql = "SELECT * FROM sucursal";
        List<SucursalEntity> sucursales = new ArrayList<>();
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    SucursalEntity sucursal = new SucursalEntity();
                    sucursal.setId(rs.getInt(1));
                    sucursal.setCalle(rs.getString(2));
                    sucursal.setCiudad(rs.getString(3));
                    sucursal.setPais(rs.getString(4));
                    sucursal.setCp(rs.getString(5));
                    sucursales.add(sucursal);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sucursales;
    }
}
