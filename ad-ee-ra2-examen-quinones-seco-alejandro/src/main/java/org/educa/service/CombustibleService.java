package org.educa.service;

import org.educa.dao.CombustibleDAO;
import org.educa.dao.CombustibleDAOImpl;
import org.educa.entity.CombustibleEntity;

public class CombustibleService {

    private final CombustibleDAO combustibleDAO = new CombustibleDAOImpl();

    /**
     * Metodo que realiza una llamada al dao de combustible para insertar un nuevo combustible
     * @param seguro del cual se va a realizar la insercion
     */
    public void create(CombustibleEntity seguro) {
        try {
            combustibleDAO.create(seguro);
            System.out.println("Transacción realizada con éxito");
        } catch (Exception e) {
            System.out.println("No se ha podido realizar la operación");
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo que realiza la busqueda de un combustible
     * @param nombre del combustible del cual realizamos la busqueda
     * @return metodo del dao que realiza la busqueda del combustible por el nombre
     */
    public CombustibleEntity findByNombre(String nombre) {
        try {
            return combustibleDAO.findByNombre(nombre);
        } catch (Exception e) {
            System.out.println("No se ha podido realizar la operación");
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo que realiza el borrado de un combustible
     * @param nombre del combustible del cual vamos a realizar el borrado
     */
    public void remove(String nombre) {
        try {
            combustibleDAO.remove(nombre);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
