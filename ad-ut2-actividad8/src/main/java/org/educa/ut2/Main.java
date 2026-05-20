package org.educa.ut2;

import org.educa.ut2.entity.ClienteEntity;
import org.educa.ut2.service.*;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ClienteService clienteService = new ClienteService();

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Introduce parte del nombre:");
            String name = sc.nextLine();

            List<ClienteEntity> clientes = clienteService.findClienteNumAlaquiler(name);
            for (ClienteEntity cliente : clientes) {
                System.out.printf("%s %s %s (%d) %n", cliente.getNombre(), cliente.getPrimerApellido(),
                        cliente.getSegundoApellido(), cliente.getNumAlquileres());
            }
        }

        System.out.println("FIN");

    }
}