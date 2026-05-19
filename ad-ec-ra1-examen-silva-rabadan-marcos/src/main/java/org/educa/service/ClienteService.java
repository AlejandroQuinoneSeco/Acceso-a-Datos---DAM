package org.educa.service;

import generated.Cliente;
import generated.Clientes;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.educa.dao.ClientesDAO;
import org.educa.dao.ClientesImpDAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class ClienteService {

    /**
     * @param metodo que devuelve una lista de clientes y metodo que crea un xml
     * @return el primer metodo devuelve una instancia de Clientes el segundo crea un XML
     * @throws FileNotFoundException
     */

    //me creo 2 rutas como constantes y relativas una para indicar de donde leer el fichero.txt
    // y otra para indicarle donde crear el xml
    private static final String RUTATXT = "src/main/resources/import/clientes.txt";
    private static final String RUTAXML = "src/main/resources/export/clientes.xml";

    // me creo una instancia de DAO para poder acceder a los datos
    ClientesDAO clientesDAO = new ClientesImpDAO();

    public Clientes readClientes() throws IOException {
        List<Cliente> listaClientes = clientesDAO.leerTxt(new File(RUTATXT));
        // creo una instancia de Clientes que es la que luego voy a retornar
        Clientes clientes = new Clientes();

        for (Cliente cli : listaClientes) {


            clientes.getCliente().add(cli);

        }
        return clientes;
    }


    public void createXML(Clientes clientes) throws JAXBException, IOException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Clientes.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(clientes, new File(RUTAXML));

    }
}
