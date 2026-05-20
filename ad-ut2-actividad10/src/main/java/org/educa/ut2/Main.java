package org.educa.ut2;

import org.educa.ut2.entity.ClienteEntity;
import org.educa.ut2.entity.DireccionEntity;
import org.educa.ut2.service.ClienteService;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            ClienteService clienteService = new ClienteService();

            System.out.print("Introduce el DNI del cliente a buscar: ");
            String dni = sc.nextLine();

            ClienteEntity cliente = clienteService.findClientByDNI(dni);

            if (cliente == null) {
                System.out.println("❌ No se encontró ningún cliente con ese DNI.");
            } else {
                System.out.println("\n=== ✅ Cliente Encontrado ===");
                System.out.println("--- Datos del cliente ---");
                System.out.println("🆔 ID: " + cliente.getIdCliente());
                System.out.println("😊 Nombre: " + cliente.getNombre() + " " + cliente.getPrimerApellido() +
                        (cliente.getSegundoApellido().isEmpty() ? "" : " " + cliente.getSegundoApellido()));
                System.out.println("✉️ Email: " + cliente.getEmail());
                System.out.println("🪪 DNI: " + cliente.getDni());
                System.out.println("☎️ Teléfono: " + (cliente.getTelefono().isEmpty() ? "(no registrado)" : cliente.getTelefono()));

                System.out.println("\n--- Direcciones asociadas  ---");
                if (cliente.getDirecciones().isEmpty()) {
                    System.out.println("Sin direcciones registradas.");
                } else {
                    for (DireccionEntity d : cliente.getDirecciones()) {
                        System.out.println("🏠 - [" + d.getIdDireccion() + "] " + d.getCalle() + ", " + d.getCiudad() +
                                ", " + d.getPais() + " (" + d.getCp() + ")");
                    }
                }
            }

        } catch (SQLException e) {
            System.err.println("❌ Error de SQL: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}