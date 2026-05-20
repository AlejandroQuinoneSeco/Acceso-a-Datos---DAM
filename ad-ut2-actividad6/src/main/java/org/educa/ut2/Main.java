package org.educa.ut2;

import org.educa.ut2.entity.VehiculoEntity;
import org.educa.ut2.service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VehiculoService vehiculoService = new VehiculoService();

        String bastidor = "";
        System.out.println("Introduzca el número de bastidor");
        try(Scanner sc = new Scanner(System.in)){
            bastidor = sc.nextLine();
        }

        VehiculoEntity vehiculo = vehiculoService.findByBastidor(bastidor);
        if (vehiculo != null){
            //id, matricula, bastidor, marca y modelo
            System.out.printf("Id: %d%n", vehiculo.getId());
            System.out.printf("Matricula: %s%n", vehiculo.getMatricula());
            System.out.printf("Bastidor: %s%n", vehiculo.getBastidor());
            System.out.printf("Marca: %s%n", vehiculo.getMarca());
            System.out.printf("Modelo: %s%n", vehiculo.getModelo());
        }

        System.out.println("FIN");


    }
}