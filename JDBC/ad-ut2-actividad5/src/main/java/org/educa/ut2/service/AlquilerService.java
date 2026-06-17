package org.educa.ut2.service;

import org.educa.ut2.dao.AlquilerDAO;
import org.educa.ut2.dao.AlquilerDAOImpl;
import org.educa.ut2.entity.AlquilerEntity;
import org.educa.ut2.entity.ClienteEntity;

import java.util.ArrayList;
import java.util.List;

public class AlquilerService {
    private final AlquilerDAO alquilerDAO = new AlquilerDAOImpl();

    public List<AlquilerEntity> findByPrecioInferior(double precio) {
        return alquilerDAO.findByPrecioInferior(precio);
    }
}
