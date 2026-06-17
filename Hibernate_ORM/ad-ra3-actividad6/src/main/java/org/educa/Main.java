package org.educa;

import org.educa.entity.CombustibleEntity;
import org.educa.service.CombustibleService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CombustibleService combustibleService = new CombustibleService();
        System.out.println("Hello, World!");
        System.out.println("Introduce un nuevo tipo de combustible");
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Introduce el nombre");
            String nombre = scanner.nextLine();
            System.out.println("Introduce la descripción");
            String descripcion = scanner.nextLine();
            CombustibleEntity combustibleEntity =
                    new CombustibleEntity(null, nombre, descripcion);
            combustibleService.save(combustibleEntity);
        }

    }
}