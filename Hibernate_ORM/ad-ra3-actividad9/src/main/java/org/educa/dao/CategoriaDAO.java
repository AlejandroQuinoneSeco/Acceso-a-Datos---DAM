package org.educa.dao;

import org.educa.entity.CategoriaEntity;

import java.util.List;

public interface CategoriaDAO {
    List<CategoriaEntity> findAll();
}
