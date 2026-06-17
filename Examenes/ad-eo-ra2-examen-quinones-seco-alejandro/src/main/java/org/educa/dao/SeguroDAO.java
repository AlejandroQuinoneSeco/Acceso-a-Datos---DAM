package org.educa.dao;

import org.educa.entity.SeguroEntity;

import java.sql.SQLException;

public interface SeguroDAO {
    void createSeguro(SeguroEntity seguro) throws SQLException;
    void deleteSeguro(String nombre) throws SQLException;
    SeguroEntity findByNombre (String nombre) throws SQLException;
}
