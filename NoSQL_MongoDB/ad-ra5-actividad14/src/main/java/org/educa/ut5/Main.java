package org.educa.ut5;

import org.educa.ut5.entity.PrestamoEntity;
import org.educa.ut5.service.PrestamosService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        PrestamosService prestamosService = new PrestamosService();
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("Introduce el ID del prestamo:");
            int id = sc.nextInt();
            sc.nextLine();
            PrestamoEntity prestamoEntity = prestamosService.findById(id);
            System.out.println(prestamoEntity);

        }
    }
}