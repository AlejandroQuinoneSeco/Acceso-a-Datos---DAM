package org.educa.ut2.dao;

import org.educa.ut2.entity.CombustibleEntity;
import org.educa.ut2.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CombustibleDAOImpl implements CombustibleDAO {


    @Override
    public List<CombustibleEntity> findAll() {
        String sql = "SELECT * FROM combustible";
        List<CombustibleEntity> combustibles = new ArrayList<>();
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    CombustibleEntity combustible = new CombustibleEntity();
                    combustible.setId(rs.getInt(1));
                    combustible.setNombre(rs.getString(2));
                    combustible.setDescripcion(rs.getString(3));
                    combustibles.add(combustible);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return combustibles;
    }
}
