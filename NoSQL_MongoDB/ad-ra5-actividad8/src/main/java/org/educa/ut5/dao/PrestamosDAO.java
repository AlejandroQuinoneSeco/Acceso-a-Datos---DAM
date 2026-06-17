package org.educa.ut5.dao;

import org.educa.ut5.entity.PrestamoEntity;

import java.util.List;

public interface PrestamosDAO {
    List<PrestamoEntity> findAll();
}
