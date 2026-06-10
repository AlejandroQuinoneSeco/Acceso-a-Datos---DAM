package org.educa.ut5.service;

import org.educa.ut5.dao.PrestamoDAO;
import org.educa.ut5.dao.PrestamoDAOImpl;
import org.educa.ut5.entity.PrestamoEntity;

public class PrestamosService {
    private final PrestamoDAO prestamoDAO = new PrestamoDAOImpl();

    public PrestamoEntity findById(int id) {
        return prestamoDAO.findById(id);
    }
}
