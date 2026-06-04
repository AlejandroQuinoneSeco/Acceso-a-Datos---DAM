package org.educa;

import org.educa.entity.AlquilerEntity;
import org.educa.entity.SeguroEntity;
import org.educa.service.SeguroService;

import java.math.RoundingMode;
import java.sql.SQLException;
import java.util.Scanner;

public class Console {
    private final SeguroService seguroService = new SeguroService();

    public void init() {
        try (Scanner sc = new Scanner(System.in)) {
            int opcion = -1;
            while (opcion != 0) {
                System.out.println("Seleccione una opción:");
                System.out.println("0. Salir");
                System.out.println("1. Inserta un nuevo tipo de seguro");
                System.out.println("2. Consulta los alquileres por tipo de seguro");
                System.out.println("3. Elimina un seguro");


                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 0:
                        System.out.println("Saliendo...");
                        break;
                    case 1:
                        createSeguro(sc);
                        break;
                    case 2:
                        findAlquileresBySeguro(sc);
                        break;
                    case 3:
                        removeSeguro(sc);
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private void createSeguro(Scanner sc) {
        System.out.println("Introduce el nombre del nuevo seguro: ");
        String nombre = sc.nextLine();
        System.out.println("Introduce la descripción del nuevo seguro: ");
        String descripcion = sc.nextLine();
        SeguroEntity seguro = new SeguroEntity();
        seguro.setNombre(nombre);
        seguro.setDescripcion(descripcion);
        seguroService.create(seguro);
    }

    private void findAlquileresBySeguro(Scanner sc) {
        System.out.println("Introduce el nombre del seguro: ");
        String nombre = sc.nextLine();
        SeguroEntity seguro = seguroService.findByNombre(nombre);
        System.out.println("Los alquileres encontrados con el seguro " + nombre + " son:");
        for (AlquilerEntity alquiler : seguro.getAlquileres()) {
            System.out.println("ID: " + alquiler.getId());
            System.out.println("Fecha Inicio: " + alquiler.getFechaIni());
            System.out.println("Fecha Fin: " + alquiler.getFechaFin());
            System.out.println("Precio: " + alquiler.getPrecio().setScale(2, RoundingMode.HALF_UP) + "€");
            System.out.println("=========================================");
        }
    }

    private void removeSeguro(Scanner sc) throws SQLException {
        System.out.println("Introduce el nombre del seguro: ");
        String nombre = sc.nextLine();
        seguroService.remove(nombre);
    }

}
