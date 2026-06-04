package org.educa;

import org.educa.entity.SucursalEntity;
import org.educa.service.SucursalService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try(Scanner scanner = new Scanner(System.in)) {
            SucursalService sucursalService = new SucursalService();
            System.out.println("Incluye una nueva sucursal");
            System.out.println("Introduce la calle:");
            String calle = scanner.nextLine();
            System.out.println("Introduce la ciudad:");
            String ciudad = scanner.nextLine();
            System.out.println("Introduce la pais:");
            String pais = scanner.nextLine();
            System.out.println("Introduce la cp:");
            String cp = scanner.nextLine();

            SucursalEntity sucursalEntity = new SucursalEntity(null, calle,
                    ciudad, pais, cp);

            sucursalService.save(sucursalEntity);

        }
    }
}