package org.educa.ut5.service;

import org.educa.ut5.dao.AutoresDAO;
import org.educa.ut5.dao.AutoresDAOImpl;
import org.educa.ut5.entity.AutorEntity;

import java.util.List;

public class AutoresService {
    private final AutoresDAO autoresDAO = new AutoresDAOImpl();

    public List<AutorEntity> findByNationality(String nacionalidad) {
        return autoresDAO.findByNationality(nacionalidad);
    }
}
