package org.educa.dao;

import org.educa.entity.VehiculoEntity;

import java.sql.SQLException;
import java.util.List;

public interface VehiculoDAO {
    /**
     * @param matricula parametro que se pasa como argumento para filtrar por matricula.
     * @param yearsOld  parametro que se pasa como argumento para filtrar por año.
     * @return retorna el vehiculo que tenga la matricula pasada por parametro y tenga mas de 5 años.
     * @throws SQLException
     */
    VehiculoEntity findByMatricula(String matricula, int yearsOld) throws SQLException;


    /**
     * @param vehiculoEntityList lista que se pasa como argumento para borrar el vehiculo con ese id
     * @throws SQLException
     */
    void deleteall(List<VehiculoEntity> vehiculoEntityList) throws SQLException;


}
