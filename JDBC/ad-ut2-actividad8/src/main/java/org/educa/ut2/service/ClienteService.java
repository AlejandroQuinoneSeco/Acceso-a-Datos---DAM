package org.educa.ut2.service;

import org.educa.ut2.dao.ClienteDAO;
import org.educa.ut2.dao.ClienteDAOImpl;
import org.educa.ut2.entity.ClienteEntity;

import java.util.List;

public class ClienteService {
    private final ClienteDAO clienteDAO = new ClienteDAOImpl();


    public List<ClienteEntity> findClienteNumAlaquiler(String name) {
        return clienteDAO.findClienteNumAlaquiler("%" + name + "%");
    }
}
