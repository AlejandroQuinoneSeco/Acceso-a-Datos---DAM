package org.educa.ut5;

import org.educa.ut5.entity.AutorEntity;
import org.educa.ut5.service.AutoresService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("Introduce el ID del autor:");
            int id = sc.nextInt();
            sc.nextLine();
            AutoresService autoresService = new AutoresService();
            AutorEntity autor = autoresService.findById(id);
            System.out.println(autor);
        }
    }
}