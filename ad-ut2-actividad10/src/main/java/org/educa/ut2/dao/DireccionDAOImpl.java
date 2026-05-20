package org.educa.ut2.dao;

import org.educa.ut2.entity.ClienteEntity;
import org.educa.ut2.entity.DireccionEntity;
import org.educa.ut2.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DireccionDAOImpl implements DireccionDAO {

    @Override
    public void loadDirecciones(ClienteEntity cliente) throws SQLException {
        if (cliente != null) {
            String sql = "SELECT * FROM direccion WHERE id_cliente = ? ";
            try (Connection connection = ConnectionPool.getDataSource().getConnection();
                 PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, cliente.getIdCliente());
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        DireccionEntity direccionEntity = new DireccionEntity();
                        direccionEntity.setIdDireccion(rs.getInt(1));
                        direccionEntity.setCalle(rs.getString(2));
                        direccionEntity.setCiudad(rs.getString(3));
                        direccionEntity.setPais(rs.getString(4));
                        direccionEntity.setCp(rs.getString(5));
                        direccionEntity.setIdCliente(rs.getInt(6));
                        cliente.getDirecciones().add(direccionEntity);
                    }
                }
            }
        }
    }
}
