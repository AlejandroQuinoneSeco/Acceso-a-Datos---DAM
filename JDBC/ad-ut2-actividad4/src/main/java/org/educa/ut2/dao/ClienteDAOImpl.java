package org.educa.ut2.dao;

import org.educa.ut2.entity.ClienteEntity;
import org.educa.ut2.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOImpl implements ClienteDAO {

    @Override
    public List<ClienteEntity> findAll() {
        List<ClienteEntity> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ClienteEntity clienteEntity = new ClienteEntity();
                    clienteEntity.setIdCliente(rs.getInt(1));
                    clienteEntity.setNombre(rs.getString(2));
                    clienteEntity.setPrimerApellido(rs.getString(3));
                    clienteEntity.setSegundoApellido(rs.getString(4));
                    clienteEntity.setEmail(rs.getString(5));
                    clienteEntity.setDni(rs.getString(6));
                    clienteEntity.setTelefono(rs.getString(7));
                    clientes.add(clienteEntity);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clientes;
    }
}
