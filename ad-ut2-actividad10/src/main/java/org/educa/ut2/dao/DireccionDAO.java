package org.educa.ut2.dao;

import org.educa.ut2.entity.ClienteEntity;

import java.sql.SQLException;

public interface DireccionDAO {
    void loadDirecciones(ClienteEntity cliente) throws SQLException;
}
