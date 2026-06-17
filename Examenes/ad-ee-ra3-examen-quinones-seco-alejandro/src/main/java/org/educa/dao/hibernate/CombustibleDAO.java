package org.educa.dao.hibernate;

import org.educa.entity.CombustibleEntity;

public interface CombustibleDAO {

    /**
     * Metodo que realiza una inserción de combustible
     * @param combustible objeto combustible el cual vamos a insertar en la BD
     */
    void create(CombustibleEntity combustible);

    /**
     * metodo que realiza una busqueda de combustible por nombre en la bd
     * @param nombre el cual pasaremos para realizar la busqueda
     * @return coches que utilizan el combustible pasado por parametro
     */
    CombustibleEntity findByNombre(String nombre);

    /**
     * metodo que realiza el borrado de un combustible
     * @param combustible nombre del combustible que queremos borrar
     */
    void remove(CombustibleEntity combustible);
}
