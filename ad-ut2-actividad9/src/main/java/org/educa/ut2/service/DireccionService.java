package org.educa.ut2.service;

import org.educa.ut2.dao.DireccionDAO;
import org.educa.ut2.dao.DireccionDAOImpl;
import org.educa.ut2.entity.ClienteEntity;

import java.sql.Connection;
import java.sql.SQLException;

public class DireccionService {
    private final DireccionDAO direccionDAO = new DireccionDAOImpl();

    public void insertDirecciones(Connection connection, ClienteEntity cliente) throws SQLException {
        direccionDAO.save(connection, cliente);
    }
}
