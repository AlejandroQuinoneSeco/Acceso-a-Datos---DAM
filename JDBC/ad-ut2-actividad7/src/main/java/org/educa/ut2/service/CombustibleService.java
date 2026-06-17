package org.educa.ut2.service;

import org.educa.ut2.dao.CombustibleDAO;
import org.educa.ut2.dao.CombustibleDAOImpl;
import org.educa.ut2.entity.CombustibleEntity;

import java.util.List;

public class CombustibleService {
    private final CombustibleDAO combustibleDAO = new CombustibleDAOImpl();

    public List<CombustibleEntity> findAll() {
        return combustibleDAO.findAll();
    }
}
