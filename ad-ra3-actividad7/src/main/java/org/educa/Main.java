package org.educa;

import org.educa.entity.AlquilerEntity;
import org.educa.service.AlquilerService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            AlquilerService alquilerService = new AlquilerService();
            System.out.println("Introduce el id de alquiler: ");
            int idAlquiler = sc.nextInt();
            sc.nextLine();
            AlquilerEntity alquilerEntity = alquilerService.findById(idAlquiler);
            System.out.println(alquilerEntity);
        }
    }
}
