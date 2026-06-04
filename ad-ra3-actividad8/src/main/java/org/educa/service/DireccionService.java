package org.educa.service;

import org.educa.dao.DireccionDAO;
import org.educa.dao.DireccionDAOImpl;
import org.educa.entity.DireccionEntity;

public class DireccionService {
    private final DireccionDAO direccionDAO = new DireccionDAOImpl();

    public void remove(DireccionEntity direccionEntity) {
        direccionDAO.remove(direccionEntity);
    }
}
