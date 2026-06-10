package org.educa.ut5.dao;

import org.educa.ut5.entity.AutorEntity;

import java.util.List;

public interface AutoresDAO {
    List<AutorEntity> findByNationality(String nacionalidad);
}
