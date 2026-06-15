package org.educa.service;

import org.educa.dao.*;
import org.educa.entity.Artista;
import org.educa.entity.Canciones;
import org.educa.entity.CancionesWithRelations;
import org.educa.entity.Generos;

import java.util.ArrayList;
import java.util.List;

public class CancionesService {

    private final CancionesDAO cancionesDAO = new CancionesDAOImpl();
    private final GenerosDAO generosDAO = new GenerosDAOImpl();
    private final ArtistaDAO artistaDAO = new ArtistaDAOImpl();

    /**
     * Metodo que realiza la logica de negocio para encontrar las canciones que se encuentran disponibles
     * @return lista de las canciones disponibles
     */
    public List<CancionesWithRelations> findAvailableCanciones() {
        List<Canciones> canciones = cancionesDAO.findAvailable();
        List<CancionesWithRelations> resultado = new ArrayList<>();

        for (Canciones c : canciones) {
            Artista artista = artistaDAO.findArtistaById(c.getDirector());
            List<Generos> generos = new ArrayList<>();

            for (Integer generoId : c.getGeneros()) {
                generos.add(generosDAO.findGeneroById(generoId));
            }
            resultado.add(new CancionesWithRelations(
                    c.getId(),
                    c.getTitulo(),
                    artista,
                    true,
                    generos
            ));
        }

        return resultado;
    }

    /**
     * Metodo que realiza una busqueda de las canciones disponibles mediante el genero
     * @param genero del cual se quiere realizar la busqueda de canciones
     * @return lista de las canciones encontradas
     */
    public List<CancionesWithRelations> findAvailableCancionesByGenre(String genero) {
        List<Canciones> canciones = cancionesDAO.findAvailableByGenero(genero);
        List<CancionesWithRelations> resultado = new ArrayList<>();

        for (Canciones c : canciones) {
            Artista artista = artistaDAO.findArtistaById(c.getDirector());
            List<Generos> generos = new ArrayList<>();

            for (Integer generoId : c.getGeneros()) {
                generos.add(generosDAO.findGeneroByName(genero));
            }
            resultado.add(new CancionesWithRelations(
                    c.getId(),
                    c.getTitulo(),
                    artista,
                    true,
                    generos
            ));
        }

        return resultado;
    }

    /**
     * Metodo que realiza el borrado de una cancion de la bd
     * @param titulo nombre de la cancion que se quiere borrar
     * @param idArtista id del artista de la cancion
     * @return devuelve el numero de canciones borradas.
     */
    public Long remove(String titulo, Integer idArtista) {
        return cancionesDAO.removeCancion(titulo, idArtista);
    }
}
