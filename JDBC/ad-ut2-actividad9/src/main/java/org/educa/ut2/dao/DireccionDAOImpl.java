package org.educa.ut2.dao;

import org.educa.ut2.entity.ClienteEntity;
import org.educa.ut2.entity.DireccionEntity;
import org.educa.ut2.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DireccionDAOImpl implements DireccionDAO {

    @Override
    public void save(Connection connection, ClienteEntity cliente) throws SQLException {
        String sql = "INSERT INTO direccion (calle, ciudad, pais, c_p, id_cliente) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            // 1️⃣ Insertar todas las direcciones
            for (DireccionEntity d : cliente.getDirecciones()) {
                d.setIdCliente(cliente.getIdCliente());
                ps.setString(1, d.getCalle());
                ps.setString(2, d.getCiudad());
                ps.setString(3, d.getPais());
                ps.setString(4, d.getCp());
                ps.setInt(5, cliente.getIdCliente());
                ps.addBatch();
            }
            ps.executeBatch();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        }
    }
}
