package org.educa.ut2.dao;

import org.educa.ut2.entity.VehiculoEntity;

import java.sql.Connection;

public interface VehiculoDAO {

    void insert(Connection conn, VehiculoEntity vehiculo);
}
