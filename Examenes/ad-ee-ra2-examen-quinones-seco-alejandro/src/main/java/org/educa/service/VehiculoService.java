package org.educa.service;

import org.educa.dao.VehiculoDAO;
import org.educa.dao.VehiculoDAOImpl;
import org.educa.entity.CombustibleEntity;
import org.educa.entity.VehiculoEntity;

import java.util.List;

public class VehiculoService {
    private final VehiculoDAO vehiculoDAO = new VehiculoDAOImpl();

    /**
     * Metodo que realiza una busqueda de los coches que utilicen el combustible que pasa el usuario
     * @param combustible nombre del combustible del cual se va a querer realizar la busqueda
     * @return metodo del dao que realiza la busqueda de los vehiculos
     */
    public List<VehiculoEntity> findByCombustible(CombustibleEntity combustible) {
        try{
            return vehiculoDAO.findByCombustible(combustible);
        } catch (Exception e) {
            System.out.println("No se ha podido realizar la operación");
            throw new RuntimeException(e);
        }
    }
}
