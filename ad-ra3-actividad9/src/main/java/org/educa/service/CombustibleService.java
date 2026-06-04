package org.educa.service;

import org.educa.dao.CombustibleDAO;
import org.educa.dao.CombustibleDAOImpl;
import org.educa.entity.CombustibleEntity;

import java.util.List;

public class CombustibleService {
    private final CombustibleDAO combustibleDAO = new CombustibleDAOImpl();

    public List<CombustibleEntity> findAll() {
        return combustibleDAO.findAll();
    }
}
