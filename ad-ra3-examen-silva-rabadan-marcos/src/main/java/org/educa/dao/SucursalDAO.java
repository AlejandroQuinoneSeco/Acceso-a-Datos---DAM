package org.educa.dao;

import org.educa.entity.SucursalEntity;

import java.util.List;

public interface SucursalDAO {

    /**
     * inserta una sucursal el sistema solicitará todos los datos
     *
     * @param sucursal instancia que se pasa al metodo
     */
    void insertSucursal(SucursalEntity sucursal);

    /**
     * Busca una sucursal por codigo postal
     *
     * @param cp parametro que se le pasa para filtrar por codigo postal
     * @return codigo postal
     */
    SucursalEntity findByCp(String cp);

    /**
     * Muestra las sucursales por calle
     *
     * @param texto parametro que se pasa como argumento para filtrar, filtramos entre minusculas y mayusculas en los dos casos
     * @return una lista de sucursales que coincida con dicho texto
     */
    List<SucursalEntity> findByCalle(String texto);

    /**
     * @param sucursal que se pasa por parametro
     * @return sucursal eliminada
     */
    void deleteSucursal(SucursalEntity sucursal);
}
