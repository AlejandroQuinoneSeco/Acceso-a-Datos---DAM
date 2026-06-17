package org.educa;

import org.educa.entity.ClienteEntity;
import org.educa.entity.DireccionEntity;
import org.educa.service.ClienteService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        ClienteService clienteService = new ClienteService();
        try(Scanner scanner = new Scanner(System.in)){

            int option;
            do {
                System.out.println("¿Qué desea 0-salir, 1-crear, 2-actualizar o 3-eliminar?");
                option = scanner.nextInt();
                scanner.nextLine();
                switch (option){
                    case 0:
                        System.out.println("Gracias por usar el programa!!");
                        break;
                    case 1:
                        crear(scanner, clienteService);
                        break;
                    case 2:
                        actualizar(scanner, clienteService);
                        break;
                    case 3:
                        eliminar(scanner, clienteService);
                        break;
                    default:
                        System.out.println("Por favor elige una opción valida");
                }
            } while (option != 0);
        }
    }

    private static void eliminar(Scanner scanner, ClienteService clienteService) {
        System.out.println("Dame el id del cliente");
        int idCliente = scanner.nextInt();
        scanner.nextLine();
        ClienteEntity cliente = clienteService.find(idCliente);
        System.out.println(cliente.toString());
        System.out.println("Are you sure? Y/n");
        String confirm = scanner.nextLine();
        if ("Y".equalsIgnoreCase(confirm)) {
            clienteService.remove(cliente);
            System.out.println("Cliente eliminado");
        } else {
            System.out.println("No se elimina cliente");
        }
    }

    private static void actualizar(Scanner scanner, ClienteService clienteService) {
        System.out.println("Dame el id del cliente");
        int idCliente = scanner.nextInt();
        scanner.nextLine();
        ClienteEntity cliente = clienteService.find(idCliente);
        System.out.println(cliente.toString());
        System.out.println("Introduce un nuevo nombre: ");
        String nombre = scanner.nextLine();
        cliente.setNombre(nombre);
        clienteService.update(cliente);
    }

    private static void crear(Scanner sc, ClienteService clienteService) {
        ClienteEntity cliente = new ClienteEntity();
        System.out.print("Nombre: ");
        cliente.setNombre(sc.nextLine().trim());
        System.out.print("Primer apellido: ");
        cliente.setPrimerApellido(sc.nextLine().trim());
        System.out.print("Segundo apellido: ");
        cliente.setSegundoApellido(sc.nextLine().trim());
        System.out.print("Email: ");
        cliente.setEmail(sc.nextLine().trim());
        System.out.print("Teléfono: ");
        cliente.setTelefono(sc.nextLine().trim());
        System.out.print("DNI: ");
        cliente.setDni(sc.nextLine().trim());
        cliente.setDirecciones(new ArrayList<>());
        System.out.println("Añade al menos una dirección");
        boolean continuar;
        do {
            System.out.print("Calle: ");
            String calle = sc.nextLine();

            System.out.print("Ciudad: ");
            String ciudad = sc.nextLine();

            System.out.print("País: ");
            String pais = sc.nextLine();

            System.out.print("Código Postal: ");
            String cPostal = sc.nextLine();

            DireccionEntity direccion = new DireccionEntity(null, calle, ciudad,
                    pais, cPostal, cliente);
            cliente.getDirecciones().add(direccion);

            System.out.print("¿Desea añadir otra dirección? (s/n): ");
            String respuesta = sc.nextLine().trim().toLowerCase();
            continuar = respuesta.equals("s");
        } while (continuar);

        clienteService.save(cliente);
        System.out.println("Cliente registrado correctamente.");
    }
}