package org.educa.ut2.service;

import org.educa.ut2.dao.ClienteDAO;
import org.educa.ut2.dao.ClienteDAOImpl;
import org.educa.ut2.entity.ClienteEntity;
import org.educa.ut2.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;

public class ClienteService {
    private final ClienteDAO clienteDAO = new ClienteDAOImpl();
    private final DireccionService direccionService = new DireccionService();

    public void insertarClienteConDirecciones(ClienteEntity cliente) throws SQLException {
        try (Connection connection = ConnectionPool.getDataSource().getConnection()) {
            connection.setAutoCommit(false);
            clienteDAO.insert(connection, cliente);
            direccionService.insertDirecciones(connection, cliente);
            connection.commit();
        }

    }
}
