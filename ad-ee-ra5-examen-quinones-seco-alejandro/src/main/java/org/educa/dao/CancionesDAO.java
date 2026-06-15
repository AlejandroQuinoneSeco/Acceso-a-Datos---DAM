package org.educa.dao;

import org.educa.entity.Canciones;

import java.util.List;

public interface CancionesDAO {

    /**
     * Metodo que realiza una busqueda de las canciones disponibles
     * @return devuelve la lista de las canciones que se encuentran disponibles
     */
    List<Canciones> findAvailable();
    /** Metodo que realiza una busqueda de las canciones disponibles filtrando por genero
     * @param genero genero de la cancion disponible
     * @return lista de canciones
     */
    List<Canciones> findAvailableByGenero(String genero);

    /**
     * Metodo que realiza el borrado de una cancion de la bd
     * @param nombre nombre de la cancion que se quiere borrar
     * @param artistaId id del artista de la cancion
     * @return devuelve el numero de canciones borradas.
     */
    Long removeCancion (String nombre, Integer artistaId);
}
