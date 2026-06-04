package org.educa;

import org.educa.entity.ClienteEntity;
import org.educa.service.ClienteService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ClienteService clienteService = new ClienteService();

            System.out.println("Introduce el idCliente: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            ClienteEntity cliente = clienteService.find(id);
            System.out.println(cliente.toString());
        }
    }
}