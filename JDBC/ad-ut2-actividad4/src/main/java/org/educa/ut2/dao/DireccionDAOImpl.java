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
    public List<DireccionEntity> findDireccionByClienteId(Integer idCliente) {
        List<DireccionEntity> direcciones = new ArrayList<>();
        String sql = "SELECT * FROM direccion WHERE id_cliente = ? ";
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idCliente);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    DireccionEntity direccionEntity = new DireccionEntity();
                    direccionEntity.setIdDireccion(rs.getInt(1));
                    direccionEntity.setCalle(rs.getString(2));
                    direccionEntity.setCiudad(rs.getString(3));
                    direccionEntity.setPais(rs.getString(4));
                    direccionEntity.setCp(rs.getString(5));
                    direccionEntity.setIdCliente(rs.getInt(6));
                    direcciones.add(direccionEntity);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return direcciones;
    }
}
