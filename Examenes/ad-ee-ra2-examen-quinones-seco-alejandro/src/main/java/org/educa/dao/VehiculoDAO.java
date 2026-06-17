package org.educa.dao;

import org.educa.entity.CombustibleEntity;
import org.educa.entity.VehiculoEntity;

import java.sql.SQLException;
import java.util.List;

public interface VehiculoDAO {
    /** Metodo que realiza una busqueda de vehiculos por combustible
     * @param combustible combustible del vehiculo del cual se realiza la busqueda
     * @return lista de vehiculos que utilizan el combustible introducido en la busqueda
     * @throws SQLException excepcion que se lanza en caso de que no se pueda realizar la operacion
     */
    List<VehiculoEntity> findByCombustible(CombustibleEntity combustible) throws SQLException;
}
