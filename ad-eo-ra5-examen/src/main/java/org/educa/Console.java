package org.educa;

import org.educa.entity.VideojuegosWithRelations;
import org.educa.service.VideojuegosService;

import java.util.List;
import java.util.Scanner;

public class Console {
    private final VideojuegosService videojuegosService = new VideojuegosService();

    public void init() {
        try (Scanner sc = new Scanner(System.in)) {
            int opcion = 0;
            while (opcion != 4) {
                System.out.println("Seleccione una opción:");
                System.out.println("1. Encontrar videojuegos disponibles");
                System.out.println("2. Encontrar videojuegos disponibles por género");
                System.out.println("3. Elimina un videojuego");
                System.out.println("4. Salir");

                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        findAvailableVideojuegos();
                        break;
                    case 2:
                        findAvailableVideojuegosByGenero(sc);
                        break;
                    case 3:
                        removeVideojuego(sc);
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

    private void findAvailableVideojuegos() {
        List<VideojuegosWithRelations> videojuegos = videojuegosService.findAvailableVideojuegos();
        if (videojuegos != null && !videojuegos.isEmpty()) {
            for (VideojuegosWithRelations videojuego : videojuegos) {
                showVideojuego(videojuego);
            }

        } else {
            System.out.println("No se han econtrado videojuegos disponibles.");
        }
        System.out.print("\n");
    }

    private void findAvailableVideojuegosByGenero(Scanner sc) {
        System.out.println("Ingrese el género");
        String genero = sc.nextLine();
        List<VideojuegosWithRelations> videojuegos = videojuegosService.findAvailableVideojuegosByGenero(genero);
        if (videojuegos != null && !videojuegos.isEmpty()) {
            for (VideojuegosWithRelations videojuego : videojuegos) {
                showVideojuego(videojuego);
            }

        } else {
            System.out.println("No se han econtrado videojuegos disponibles con ese género.");
        }
        System.out.print("\n");
    }

    private void removeVideojuego(Scanner sc) {
        System.out.println("Ingrese el titulo del videojuego:");
        String title = sc.nextLine();
        System.out.println("Ingrese el id del estudio:");
        Integer idEstudio = sc.nextInt();

        Long deletedCount = videojuegosService.remove(title, idEstudio);
        System.out.println("Se han eliminado un total de " + deletedCount + " videojuegos");
        System.out.print("\n");
    }

    private void showVideojuego(VideojuegosWithRelations videojuego) {
        System.out.println("ID: " + videojuego.getId());
        System.out.println("Título: " + videojuego.getTitulo());
        System.out.println("Autor: " + videojuego.getEstudio().getNombre());
        System.out.println("Disponibilidad: " + videojuego.getDisponible());
        System.out.println("Géneros: " + videojuego.getGeneros());
        System.out.println("==================================");
    }

}
