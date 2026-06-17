package org.educa.ut2;

import org.educa.ut2.service.AlquilerService;

public class Main {
    public static void main(String[] args) {

        AlquilerService alquilerService = new AlquilerService();

        alquilerService.addDiscountToPriceByMarca("Seat", 2.00);

        System.out.println("FIN");


    }
}