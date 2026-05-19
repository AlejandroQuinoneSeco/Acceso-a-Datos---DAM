package org.educa.dao;

import generated.Cliente;
import generated.Direccion;
import generated.Nombre;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ClientesImpDAO implements ClientesDAO {
    /**
     * @param file documento txt que recibo para leer
     * @return lista de Cliente que devuelve mi metodo
     * @throws FileNotFoundException
     */
    @Override
    public List<Cliente> leerTxt(File file) throws FileNotFoundException {
        List<Cliente> listaClientes = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            //aqui salto la primera linea informativa
            String linea = bufferedReader.readLine();

            while ((linea = bufferedReader.readLine()) != null) {

                //me creo un array de clientes y lo voy spliteando por comas
                String[] clientes = linea.split(",");

                // me creo 3 instancias
                Cliente cliente = new Cliente();
                Nombre nombre = new Nombre();
                Direccion direccion = new Direccion();

                // voy seteando en base a la posicion de mi array
                nombre.setValue(clientes[0]);
                nombre.setDni(clientes[1]);
                cliente.setEmail(clientes[2]);
                direccion.setCalle(clientes[3]);
                direccion.setCiudad(clientes[4]);
                direccion.setPais(clientes[5]);
                direccion.setCp(clientes[6]);

                // voy seteando y metiendolo en la instancia de cliente
                cliente.setNombre(nombre);
                cliente.setEmail(cliente.getEmail());
                cliente.setDireccion(direccion);

                // por ultimo lo añado a la lista de clientes
                listaClientes.add(cliente);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return listaClientes;
    }
}
