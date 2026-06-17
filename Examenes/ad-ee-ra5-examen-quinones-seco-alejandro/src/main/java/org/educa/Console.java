package org.educa;

import org.educa.entity.CancionesWithRelations;
import org.educa.service.CancionesService;

import java.util.List;
import java.util.Scanner;

public class Console {
    private final CancionesService cancionesService = new CancionesService();

    public void init() {
        try (Scanner sc = new Scanner(System.in)) {
            int opcion = 0;
            while (opcion != 4) {
                System.out.println("Seleccione una opción:");
                System.out.println("1. Encontrar canciones disponibles");
                System.out.println("2. Encontrar canciones disponibles por género");
                System.out.println("3. Elimina una canción");
                System.out.println("4. Salir");

                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        findAvailableSongs();
                        break;
                    case 2:
                        findAvailableSongsByGenre(sc);
                        break;
                    case 3:
                        removeSong(sc);
                        break;
                    case 4:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void findAvailableSongs() {
        List<CancionesWithRelations> songs = cancionesService.findAvailableCanciones();
        if (songs != null && !songs.isEmpty()) {
            for (CancionesWithRelations song : songs) {
                showSong(song);
            }

        } else {
            System.out.println("No se han econtrado canciones disponibles.");
        }
        System.out.print("\n");
    }

    private void findAvailableSongsByGenre(Scanner sc) {
        System.out.println("Ingrese el género");
        String genre = sc.nextLine();
        List<CancionesWithRelations> songs = cancionesService.findAvailableCancionesByGenre(genre);
        if (songs != null && !songs.isEmpty()) {
            for (CancionesWithRelations song : songs) {
                showSong(song);
            }

        } else {
            System.out.println("No se han econtrado canciones disponibles con ese género.");
        }
        System.out.print("\n");
    }

    private void removeSong(Scanner sc) {
        System.out.println("Ingrese titulo de la canción:");
        String title = sc.nextLine();
        System.out.println("Ingrese el id del artista:");
        Integer idArtista = sc.nextInt();

        Long deletedCount = cancionesService.remove(title, idArtista);
        System.out.println("Se han eliminado un total de " + deletedCount + " canciones");
        System.out.print("\n");
    }

    private void showSong(CancionesWithRelations song) {
        System.out.println("ID: " + song.getId());
        System.out.println("Título: " + song.getTitulo());
        System.out.println("Director: " + song.getArtista().getNombre());
        System.out.println("Disponibilidad: " + song.getDisponible());
        System.out.println("Generos: " + song.getGeneros());
        System.out.println("==================================");
    }

}
