package org.educa.ut5;


import org.educa.ut5.entity.LibroEntity;
import org.educa.ut5.service.LibroService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        LibroService prestamosService = new LibroService();
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("Introduce el titulo del libro:");
            String titulo = sc.nextLine();
            List<LibroEntity> libros = prestamosService.findByTitle(titulo);
            libros.forEach(System.out::println);
        }
    }
}