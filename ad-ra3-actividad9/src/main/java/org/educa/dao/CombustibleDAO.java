package org.educa.dao;

import org.educa.entity.CombustibleEntity;

import java.util.List;

public interface CombustibleDAO {
    List<CombustibleEntity> findAll();
}
