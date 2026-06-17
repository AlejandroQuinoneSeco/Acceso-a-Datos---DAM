package org.educa.dao;

import org.educa.entity.CombustibleEntity;
import org.educa.pool.ConnectionPool;

import java.sql.*;

public class CombustibleDAOImpl implements CombustibleDAO{

    @Override
    public void create(CombustibleEntity seguro) throws SQLException {
        String sql = "INSERT INTO combustible (nombre, descripcion) VALUES (?, ?)";

        try (Connection conn = ConnectionPool.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, seguro.getNombre());
            ps.setString(2, seguro.getDescripcion());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    rs.getInt(1);
                }
            }
        }
    }

    @Override
    public CombustibleEntity findByNombre(String nombre) throws SQLException {
        CombustibleEntity combustible = null;
        String sql = "SELECT * FROM combustible WHERE LOWER(nombre) = LOWER(?)";

        try (Connection conn = ConnectionPool.getDataSource().getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nombre);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    combustible = new CombustibleEntity();
                    combustible.setId(rs.getInt("id_comb"));
                    combustible.setNombre(rs.getString("nombre"));
                    combustible.setDescripcion(rs.getString("descripcion"));
                }
            }
        }
        return combustible;
    }


    @Override
    public void remove(String nombre) throws SQLException {
        String sql = "DELETE FROM combustible WHERE LOWER(nombre) = LOWER(?)";

        try (Connection conn = ConnectionPool.getDataSource().getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ps.executeUpdate();

        }
    }
}
