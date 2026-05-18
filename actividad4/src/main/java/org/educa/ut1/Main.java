package org.educa.ut1;

import org.educa.ut1.service.DataService;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String FILE = "/home/madrid/Documentos/AD/UT1/enteros.dat";

    public static void main(String[] args) {
        // Llamar al servicio para obtener los datos de enteros.dat
        DataService dataService = new DataService();
        print(dataService);
        //Pedir numero por teclado
        System.out.println("Inserte un número entero:");
        try (Scanner sc = new Scanner(System.in)) {
            int numero = sc.nextInt();
            sc.nextLine();
            // Añadir el número a enteros.dat
            dataService.addInteger(numero, FILE);
            print(dataService);
        }
    }

    private static void print(DataService dataService) {
        List<Integer> enteros = dataService.readFile(FILE);
        for (Integer entero : enteros) {
            System.out.println(entero);
        }
    }
}