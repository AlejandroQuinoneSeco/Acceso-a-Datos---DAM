package org.educa.dao;

import org.educa.entity.AlquilerEntity;
import org.educa.entity.SeguroEntity;

import java.sql.SQLException;

public interface AlquilerDAO {
    AlquilerEntity findAlquiler(SeguroEntity seguro) throws SQLException;
}
