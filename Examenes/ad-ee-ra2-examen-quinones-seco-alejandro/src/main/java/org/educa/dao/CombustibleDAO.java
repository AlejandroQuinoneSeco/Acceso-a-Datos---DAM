package org.educa.dao;

import org.educa.entity.CombustibleEntity;

import java.sql.SQLException;

public interface CombustibleDAO {
    /** Method que realiza una inserción de un combustible en la tabla vehículos
     * @param seguro
     * @throws SQLException excecpion sql que se lanza si la creación ha sido incorrecta
     */
    void create(CombustibleEntity seguro) throws SQLException;
    /** Method que realiza una busqueda de combustibles por nombre de combustible
     * @param nombre del combustible que vamos a buscar
     * @return combustible del cual hemos realizado la busqueda
     * @throws SQLException excepcion que se lanza si no se encuentra ningun combustible con ese nombre
     */
    CombustibleEntity findByNombre(String nombre) throws SQLException;
    /** Method que realiza un borrado de combustible en caso de que no tenga vehiculos asociados
     * @param nombre nombre del combustible que vamos a borrar
     * @throws SQLException excepcion que se lanzará en caso de que el combustible tenga vehiculos asociados
     */
    void remove(String nombre) throws SQLException;
}
