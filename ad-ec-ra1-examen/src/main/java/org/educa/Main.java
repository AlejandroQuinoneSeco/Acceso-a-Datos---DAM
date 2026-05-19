package org.educa;

import generated.Clientes;
import org.educa.service.ClienteService;

public class Main {
    public static void main(String[] args) {
        ClienteService clienteService = new ClienteService();
        System.out.println("Bienvenido al programa para parsear personas de TXT a XML.");
        try {
            //Actividad 1
            Clientes clientes = clienteService.readClientes();
            //Actividad 2
            clienteService.createXML(clientes);
        } catch (Exception e) {
            System.err.println("Se ha producido una excepción");
            throw new RuntimeException(e);
        }
    }
}