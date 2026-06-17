package org.educa.service;

import org.educa.dao.hibernate.CombustibleDAO;
import org.educa.dao.hibernate.CombustibleDAOImpl;
import org.educa.entity.CombustibleEntity;


public class CombustibleService {

    private final CombustibleDAO combustibleDAO = new CombustibleDAOImpl();

    /**
     * Metodo que realiza una inserción de combustible
     * @param combustible objeto combustible el cual vamos a insertar en la BD
     */
    public void create(CombustibleEntity combustible) {
        try {
            combustibleDAO.create(combustible);
            System.out.println("Transacción realizada con éxtio");
        } catch (Exception e) {
            System.out.println("No se ha podido realizar la operación");
            throw new RuntimeException(e);
        }
    }
    /**
     * metodo que realiza una busqueda de combustible por nombre en la bd
     * @param nombre el cual pasaremos para realizar la busqueda
     * @return coches que utilizan el combustible pasado por parametro
     */
    public CombustibleEntity findByNombre(String nombre) {
        try{
            return combustibleDAO.findByNombre(nombre);
        } catch (Exception e) {
            System.out.println("No se ha podido realizar la operación");
            throw new RuntimeException(e);
        }
    }

    /**
     * metodo que realiza el borrado de un combustible
     * @param nombre del combustible a borrar
     */
    public void remove(String nombre) {
        CombustibleEntity combustible = findByNombre(nombre);
        combustibleDAO.remove(combustible);
    }
}
