package org.educa.ut2.dao;

import org.educa.ut2.entity.ClienteEntity;
import org.educa.ut2.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOImpl implements ClienteDAO {

    @Override
    public List<ClienteEntity> findClienteNumAlaquiler(String name) {
        List<ClienteEntity> clientes = new ArrayList<>();
        String sql = "SELECT a.id_cliente, c.nombre, c.p_apellido, c.s_apellido, count(a.id_cliente) " +
                "from alquiler a " +
                "inner join cliente c on a.id_cliente = c.id_cliente " +
                "where c.nombre like ? " +
                "group by (a.id_cliente, c.nombre, c.p_apellido, c.s_apellido)";
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ClienteEntity clienteEntity = new ClienteEntity();
                    clienteEntity.setIdCliente(rs.getInt(1));
                    clienteEntity.setNombre(rs.getString(2));
                    clienteEntity.setPrimerApellido(rs.getString(3));
                    clienteEntity.setSegundoApellido(rs.getString(4));
                    clienteEntity.setNumAlquileres(rs.getInt(5));
                    clientes.add(clienteEntity);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clientes;
    }
}
