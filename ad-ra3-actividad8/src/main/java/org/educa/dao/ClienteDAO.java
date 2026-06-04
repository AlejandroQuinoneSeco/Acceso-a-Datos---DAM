package org.educa.dao;

import org.educa.entity.ClienteEntity;

public interface ClienteDAO {
    ClienteEntity findById(int idCliente);
}
