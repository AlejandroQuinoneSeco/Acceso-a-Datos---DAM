package org.educa.dao;

import org.educa.entity.ClienteEntity;

public interface ClienteDAO {
    void save(ClienteEntity cliente);

    ClienteEntity find(int id);

    void update(ClienteEntity cliente);

    void remove(ClienteEntity cliente);
}
