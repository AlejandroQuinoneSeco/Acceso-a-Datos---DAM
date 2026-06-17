package org.educa.ut2.dao;

import org.educa.ut2.entity.ClienteEntity;
import org.educa.ut2.entity.DireccionEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface DireccionDAO {

    void save(Connection connection, ClienteEntity cliente) throws SQLException;
}
