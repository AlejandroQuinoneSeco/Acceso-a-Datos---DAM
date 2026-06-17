package org.educa.ut2.dao;

import org.educa.ut2.entity.CategoriaEntity;
import org.educa.ut2.entity.SucursalEntity;
import org.educa.ut2.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAOImpl implements CategoriaDAO {
    @Override
    public List<CategoriaEntity> findAll() {
        String sql = "SELECT * FROM categoria";
        List<CategoriaEntity> categorias = new ArrayList<>();
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    CategoriaEntity categoria = new CategoriaEntity();
                    categoria.setIdCategoria(rs.getInt(1));
                    categoria.setNombre(rs.getString(2));
                    categoria.setDescripcion(rs.getString(3));
                    categorias.add(categoria);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categorias;
    }
}
