package org.educa.dao;

import org.educa.entity.Artista;

public interface ArtistaDAO {

    /** Metodo que busca un artista de la bd por id
     * @param artistaId id del artista en la bd
     * @return el artista encontrado tras la búsqueda
     */
    Artista findArtistaById(Integer artistaId);
}
