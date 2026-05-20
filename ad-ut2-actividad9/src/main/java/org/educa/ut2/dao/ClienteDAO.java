package org.educa.ut2.dao;

import org.educa.ut2.entity.ClienteEntity;

import java.sql.Connection;
import java.sql.SQLException;

public interface ClienteDAO {

    void insert(Connection connection, ClienteEntity cliente) throws SQLException;
}
