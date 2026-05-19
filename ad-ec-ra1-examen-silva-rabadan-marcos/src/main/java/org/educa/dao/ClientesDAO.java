package org.educa.dao;

import generated.Cliente;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;


public interface ClientesDAO {

    /**
     * @param file documento txt que recibo para leer
     * @return lista de Cliente que devuelve
     * @throws FileNotFoundException
     */
    List<Cliente> leerTxt(File file) throws FileNotFoundException;
}
