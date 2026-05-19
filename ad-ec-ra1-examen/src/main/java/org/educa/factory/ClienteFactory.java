package org.educa.factory;

import generated.Cliente;
import generated.Clientes;
import generated.Direccion;
import generated.Nombre;

public class ClienteFactory {
    /**
     * Genera Clientes
     *
     * @return Clientes con toda la información
     */
    public static Clientes create() {
        Clientes clientes = new Clientes();

        Cliente cliente1 = new Cliente();
        Nombre nombre1 = new Nombre();
        nombre1.setValue("Paco Polo Pérez");
        nombre1.setDni("00000000X");
        cliente1.setNombre(nombre1);
        cliente1.setEmail("ppp@mail.com");
        Direccion direccion1 = new Direccion();
        direccion1.setCalle("C/Gaviota 22");
        direccion1.setCiudad("Badajoz");
        direccion1.setPais("España");
        direccion1.setCp("010101");
        cliente1.setDireccion(direccion1);
        clientes.getCliente().add(cliente1);

        Cliente cliente2 = new Cliente();
        Nombre nombre2 = new Nombre();
        nombre2.setValue("Marcos Alonso Pérez");
        nombre2.setDni("00000001R");
        cliente2.setNombre(nombre2);
        cliente2.setEmail("map@mail.com");
        Direccion direccion2 = new Direccion();
        direccion2.setCalle("C/Alegria 33");
        direccion2.setCiudad("Madrid");
        direccion2.setPais("España");
        direccion2.setCp("282828");
        cliente2.setDireccion(direccion2);
        clientes.getCliente().add(cliente2);

        return clientes;
    }
}
