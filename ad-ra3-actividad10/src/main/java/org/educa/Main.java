package org.educa;

import org.educa.service.AlquilerService;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            AlquilerService alquilerService = new AlquilerService();
            System.out.println("Introduce marca: ");
            String marca = sc.nextLine();
            System.out.println("Introduce modelo: ");
            String modelo = sc.nextLine();
            System.out.println("Introduce descuento: ");
            BigDecimal descuento = sc.nextBigDecimal();
            sc.nextLine();
            alquilerService.aplicaDescuento(marca, modelo, descuento);
        }
    }
}
