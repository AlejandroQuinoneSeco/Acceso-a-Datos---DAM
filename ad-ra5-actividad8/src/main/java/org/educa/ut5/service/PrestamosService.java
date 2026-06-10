package org.educa.ut5.service;

import org.educa.ut5.dao.PrestamosDAO;
import org.educa.ut5.dao.PrestamosDAOImpl;
import org.educa.ut5.entity.PrestamoEntity;

import java.util.List;

public class PrestamosService {
    private final PrestamosDAO prestamosDAO = new PrestamosDAOImpl();


    public List<PrestamoEntity> findAll() {
        return prestamosDAO.findAll();
    }
}
