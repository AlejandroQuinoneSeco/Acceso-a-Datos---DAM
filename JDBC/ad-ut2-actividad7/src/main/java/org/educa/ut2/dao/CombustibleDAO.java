package org.educa.ut2.dao;

import org.educa.ut2.entity.CombustibleEntity;

import java.util.List;

public interface CombustibleDAO {
    List<CombustibleEntity> findAll();
}
