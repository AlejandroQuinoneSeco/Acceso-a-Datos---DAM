package org.educa.ut2.service;

import org.educa.ut2.dao.ClienteDAO;
import org.educa.ut2.dao.ClienteDAOImpl;
import org.educa.ut2.entity.ClienteEntity;

import java.util.List;

public class ClienteService {
    private final ClienteDAO clienteDAO = new ClienteDAOImpl();
    private final DireccionService direccionService = new DireccionService();


    public List<ClienteEntity> findAll() {
        List<ClienteEntity> clientes = clienteDAO.findAll();
        direccionService.loadDirecciones(clientes);
        return clientes;
    }
}
