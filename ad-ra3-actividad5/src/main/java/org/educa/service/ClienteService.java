package org.educa.service;

import org.educa.dao.ClienteDAO;
import org.educa.dao.ClienteDAOImpl;
import org.educa.entity.ClienteEntity;

public class ClienteService {
    private final ClienteDAO clienteDAO = new ClienteDAOImpl();

    public void save(ClienteEntity cliente) {
        clienteDAO.save(cliente);
    }

    public ClienteEntity find(int id) {
        return clienteDAO.find(id);
    }

    public void update(ClienteEntity cliente) {
        clienteDAO.update(cliente);
    }

    public void remove(ClienteEntity cliente) {
        clienteDAO.remove(cliente);
    }
}
