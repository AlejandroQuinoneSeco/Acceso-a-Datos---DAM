package org.educa.service;

import org.educa.dao.AlquilerDAO;
import org.educa.dao.AlquilerDAOImpl;
import org.educa.entity.AlquilerEntity;
import org.educa.entity.SeguroEntity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlquilerService {
    private final AlquilerDAO alquilerDAO = new AlquilerDAOImpl();

    /** Método para realizar una busqueda de alquileres por el nombre del seguro
     * @param seguro
     * @return lista de alquileres
     * @throws SQLException
     */
    public List<AlquilerEntity> findBySeguro(SeguroEntity seguro) {

        List<AlquilerEntity> alquilerEntities = new ArrayList<>();

        try {
            alquilerDAO.findAlquiler(seguro);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return alquilerEntities;
    }
}
