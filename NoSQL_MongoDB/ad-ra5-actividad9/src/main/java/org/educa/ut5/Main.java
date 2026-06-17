package org.educa.ut5;

import org.educa.ut5.entity.AutorEntity;
import org.educa.ut5.service.AutoresService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        try(Scanner sc = new Scanner(System.in)) {
            System.out.println("Introduce la nacionalidad: ");
            String nacionalidad = sc.nextLine();
            AutoresService autoresService = new AutoresService();
            List<AutorEntity> autores = autoresService.findByNationality(nacionalidad);
            for(AutorEntity autor : autores) {
                System.out.println(autor);
            }
        }
    }
}