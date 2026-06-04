package org.educa.service;

import org.educa.dao.SucursalDAO;
import org.educa.dao.SucursalmpDAO;
import org.educa.entity.SucursalEntity;

import java.util.List;

public class SucursalService {
    private final SucursalDAO sucursalDAO = new SucursalmpDAO();

    /**
     * inserta una sucursal el sistema solicitará todos los datos
     *
     * @param sucursal instancia que se pasa al metodo
     */
    public void insertar(SucursalEntity sucursal) {

        sucursalDAO.insertSucursal(sucursal);
    }

    /**
     * Busca una sucursal por codigo postal
     *
     * @param cp parametro que se le pasa para filtrar por codigo postal
     * @return sucursal indicada
     */
    public SucursalEntity findByCP(String cp) {
        return sucursalDAO.findByCp(cp);
    }

    /**
     * borrar una sucursal pasando por parametro su codigo postal
     *
     * @param cp parametro que se le pasa como argumento para eliminar dicha sucursal
     * @return retorno del id de dicha sucursal eliminada.
     */
    public Integer deleteByCP(String cp) {
        SucursalEntity sucursal = null;

        sucursal = sucursalDAO.findByCp(cp);

        Integer idSucursal = 0;
        if (sucursal != null) {

            idSucursal = sucursal.getId();
            sucursalDAO.deleteSucursal(sucursal);

        }
        return idSucursal;
    }

    /**
     * Muestra las sucursales por calle
     *
     * @param texto parametro que se pasa como argumento para filtrar, filtramos entre minusculas y mayusculas en los dos casos
     * @return lista de sucursales filtradas por el texto
     */
    public List<SucursalEntity> findByCalle(String texto) {
        return sucursalDAO.findByCalle(texto);
    }
}
