package org.educa;

import org.educa.entity.CombustibleEntity;
import org.educa.entity.VehiculoEntity;
import org.educa.service.CombustibleService;

import java.sql.SQLException;
import java.util.Scanner;

public class Console {
    private final CombustibleService combustibleService = new CombustibleService();

    public void init() {
        try (Scanner sc = new Scanner(System.in)) {
            int opcion = -1;
            while (opcion != 0) {
                System.out.println("Seleccione una opción:");
                System.out.println("0. Salir");
                System.out.println("1. Inserta un nuevo combustible");
                System.out.println("2. Consulta los vehículos por tipo de combustible");
                System.out.println("3. Elimina un combustible");


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
                        findVehiculosByCombustible(sc);
                        break;
                    case 3:
                        removeCombustible(sc);
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
        System.out.println("Introduce el nombre del nuevo combustible: ");
        String nombre = sc.nextLine();
        System.out.println("Introduce la descripción del nuevo combustible: ");
        String descripcion = sc.nextLine();
        CombustibleEntity combustible = new CombustibleEntity();
        combustible.setNombre(nombre);
        combustible.setDescripcion(descripcion);
        combustibleService.create(combustible);
    }

    private void findVehiculosByCombustible(Scanner sc) {
        System.out.println("Introduce el nombre del combustible: ");
        String nombre = sc.nextLine();
        CombustibleEntity combustible = combustibleService.findByNombre(nombre);
        System.out.println("Los vehículos encontrados con el combustible " + nombre + " son:");
        for (VehiculoEntity vehiculo : combustible.getVehiculos()) {
            System.out.println("ID: " + vehiculo.getId());
            System.out.println("Matricula: " + vehiculo.getMatricula());
            System.out.println("Bastidor: " + vehiculo.getBastidor());
            System.out.println("=========================================");
        }
    }

    private void removeCombustible(Scanner sc) throws SQLException {
        System.out.println("Introduce el nombre del combustible: ");
        String nombre = sc.nextLine();
        combustibleService.remove(nombre);
    }

}
