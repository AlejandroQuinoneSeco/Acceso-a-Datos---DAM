package org.educa.service;

import org.educa.dao.VehiculoDAO;
import org.educa.dao.VehiculoImpDAO;
import org.educa.entity.VehiculoEntity;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class VehiculoService {

    private final VehiculoDAO vehiculoDAO = new VehiculoImpDAO();

    /**
     * @param matricula argumento que se pasa para filtrar por matricula
     * @param yearsOld  me creo una variable para sacar el año actual y le resto yearsOld que es el parametro que se pasa en el main.
     * @return retorno el vehiculo con el filtrado de esos parametros.
     * @throws SQLException
     */
    public VehiculoEntity findByMatricula(String matricula, int yearsOld) throws SQLException {

        int añoActu = LocalDate.now().getYear();
        yearsOld = añoActu - yearsOld;

        return vehiculoDAO.findByMatricula(matricula, yearsOld);
    }


    /**
     * @param vehiculos elimino los vehiculos que cumplen con las condiciones establecidas.
     * @throws SQLException
     */
    public void deleteAll(List<VehiculoEntity> vehiculos) throws SQLException {

        vehiculoDAO.deleteall(vehiculos);

    }
}
