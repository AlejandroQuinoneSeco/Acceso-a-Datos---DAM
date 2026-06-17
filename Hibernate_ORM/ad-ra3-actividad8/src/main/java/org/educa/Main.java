package org.educa;

import org.educa.entity.ClienteEntity;
import org.educa.entity.DireccionEntity;
import org.educa.service.ClienteService;
import org.educa.service.DireccionService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClienteService clienteService = new ClienteService();
        DireccionService direccionService = new DireccionService();
        System.out.println("Hello, World!");
        System.out.println("Introduce un id de cliente: ");
        try (Scanner sc = new Scanner(System.in)){
            int idCliente = sc.nextInt();
            sc.nextLine();
            ClienteEntity cliente = clienteService.findById(idCliente);
            System.out.println("Selecciona una direccion a eliminar");
            int cont = 1;
            for (DireccionEntity direccion : cliente.getDirecciones()){
                System.out.println(cont + " - " + direccion.getCalle() + " (" + direccion.getCiudad() + ") ");
                cont++;
            }
            int indexDireccion = sc.nextInt();
            sc.nextLine();
            direccionService.remove(cliente.getDirecciones().get(indexDireccion-1));
        }
    }
}