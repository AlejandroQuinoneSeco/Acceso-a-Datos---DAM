package org.educa.ut2;

import org.educa.ut2.entity.ClienteEntity;
import org.educa.ut2.entity.DireccionEntity;
import org.educa.ut2.service.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ClienteService clienteService = new ClienteService();

        List<ClienteEntity> clientes = clienteService.findAll();
        for (ClienteEntity cliente: clientes) {
            System.out.println("DNI: " +  cliente.getDni());
            System.out.println("Nombre: " +  cliente.getNombre());
            System.out.println("Primer Apellido: " +  cliente.getPrimerApellido());
            System.out.println("Segundo Apellido: " +  cliente.getSegundoApellido());
            for (DireccionEntity direccion:cliente.getDirecciones()) {
                System.out.println("CP: " +  direccion.getCp());
            }
            System.out.println("==============================================");
        }

        System.out.println("FIN");

    }
}