package org.educa.ut2;

import org.educa.ut2.entity.ClienteEntity;
import org.educa.ut2.entity.DireccionEntity;
import org.educa.ut2.service.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            System.out.println("=== Registro de cliente con múltiples direcciones ===");
            System.out.println("Nombre: ");
            String nombre = sc.nextLine();

            System.out.println("Primer apellido: ");
            String pApellido = sc.nextLine();

            System.out.println("Segundo apellido (opcional): ");
            String sApellido = sc.nextLine();

            System.out.println("Email: ");
            String email = sc.nextLine();

            System.out.println("DNI: ");
            String dni = sc.nextLine();

            System.out.println("Teléfono (opcional): ");
            String telefono = sc.nextLine();

            ClienteEntity cliente = new ClienteEntity(null, nombre, pApellido, sApellido, email, dni, telefono, new ArrayList<>());

            System.out.println("--- Introducción de direcciones ---");
            boolean continuar = true;
            while (continuar) {
                System.out.println("Calle: ");
                String calle = sc.nextLine();

                System.out.println("Ciudad: ");
                String ciudad = sc.nextLine();

                System.out.println("País: ");
                String pais = sc.nextLine();

                System.out.println("Código Postal: ");
                String cPostal = sc.nextLine();

                DireccionEntity direccion = new DireccionEntity(null, calle, ciudad, pais, cPostal, null);
                cliente.getDirecciones().add(direccion);

                System.out.print("¿Desea añadir otra dirección? (s/n): ");
                String respuesta = sc.nextLine().trim().toLowerCase();
                continuar = respuesta.equals("s");
            }

            ClienteService clienteService = new ClienteService();
            clienteService.insertarClienteConDirecciones(cliente);
            System.out.println("✅ Cliente y sus direcciones registrados correctamente.");

        } catch (SQLException e) {
            System.err.println("❌ Error en la transacción, se ha revertido: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}