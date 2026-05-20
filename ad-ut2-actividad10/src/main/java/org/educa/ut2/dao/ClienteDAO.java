package org.educa.ut2.dao;

import org.educa.ut2.entity.ClienteEntity;

import java.sql.SQLException;

public interface ClienteDAO {

    ClienteEntity findByDNI(String dni) throws SQLException;
}
