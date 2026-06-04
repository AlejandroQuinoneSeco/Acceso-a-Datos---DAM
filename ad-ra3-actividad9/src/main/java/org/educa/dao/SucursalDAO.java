package org.educa.dao;

import org.educa.entity.SucursalEntity;

import java.util.List;

public interface SucursalDAO {
    List<SucursalEntity> findAll();
}
