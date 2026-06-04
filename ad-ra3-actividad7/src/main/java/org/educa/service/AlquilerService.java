package org.educa.service;

import org.educa.dao.AlquilerDAO;
import org.educa.dao.AlquilerDAOImpl;
import org.educa.entity.AlquilerEntity;

public class AlquilerService {
    private final AlquilerDAO alquilerDAO = new AlquilerDAOImpl();

    public AlquilerEntity findById(int idAlquiler) {
        return alquilerDAO.findById(idAlquiler);
    }
}
