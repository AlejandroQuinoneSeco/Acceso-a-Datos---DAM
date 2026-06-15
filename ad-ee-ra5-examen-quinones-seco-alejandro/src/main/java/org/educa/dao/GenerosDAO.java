package org.educa.dao;

import org.educa.entity.Generos;

public interface GenerosDAO {
    /** metodo que realiza una busqueda de un genero mediante el id del genero
     * @param generoId id del genero del cual se quiere realizar la busqueda
     * @return el genero encontrado tras la busqueda
     */
    Generos findGeneroById(Integer generoId);

    /**
     * Metodo que realiza una busqueda de un genero por el nombre
     * @param nombre del genero del que se quiere realizar la busqueda
     * @return genero encontrado
     */
    Generos findGeneroByName(String nombre);
}
