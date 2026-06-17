package org.educa.ut2.service;

import org.educa.ut2.dao.ClienteDAO;
import org.educa.ut2.dao.ClienteDAOImpl;
import org.educa.ut2.entity.ClienteEntity;

import java.sql.SQLException;

public class ClienteService {
    private final ClienteDAO clienteDAO = new ClienteDAOImpl();
    private final DireccionService direccionService = new DireccionService();

    public ClienteEntity findClientByDNI(String dni) throws SQLException {
        ClienteEntity cliente = clienteDAO.findByDNI(dni);
        direccionService.loadDirecciones(cliente);
        return cliente;
    }
}
