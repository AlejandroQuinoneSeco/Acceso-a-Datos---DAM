package org.educa.ut1;

import org.educa.ut1.service.DataService;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String FILE = "/home/madrid/Documentos/AD/UT1/enteros.dat";
    public static void main(String[] args) {
        //Mostrar enteros -> Leer enteros del fichero
        DataService dataService = new DataService();
        print(dataService);
        //Pedir la posición
        System.out.println("Indique la posición del número a modificar:");
        Scanner sc = new Scanner(System.in);
        int posicion = sc.nextInt();
        sc.nextLine();
        //Pedir el número
        System.out.println("Inserte un número entero:");
        int numero = sc.nextInt();
        sc.nextLine();
        //Modificar el numero de la posición dada por el entero pasado por el usuario
        dataService.replaceInteger(posicion, numero, FILE);
        //Mostrar enteros
        print(dataService);
    }

    private static void print(DataService dataService) {
        List<Integer> enteros = dataService.readFile(FILE);
        for (Integer entero : enteros) {
            System.out.println(entero);
        }
    }
}