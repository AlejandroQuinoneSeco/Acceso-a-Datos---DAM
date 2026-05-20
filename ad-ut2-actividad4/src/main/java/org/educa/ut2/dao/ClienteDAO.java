package org.educa.ut2.dao;

import org.educa.ut2.entity.ClienteEntity;

import java.util.List;

public interface ClienteDAO {

    List<ClienteEntity> findAll();

}
