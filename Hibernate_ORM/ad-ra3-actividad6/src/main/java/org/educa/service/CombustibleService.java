package org.educa.service;

import org.educa.dao.CombustibleDAO;
import org.educa.dao.CombustibleDAOImpl;
import org.educa.entity.CombustibleEntity;

public class CombustibleService {
    private final CombustibleDAO combustibleDAO = new CombustibleDAOImpl();

    public void save(CombustibleEntity combustibleEntity) {
        combustibleDAO.save(combustibleEntity);
    }
}
