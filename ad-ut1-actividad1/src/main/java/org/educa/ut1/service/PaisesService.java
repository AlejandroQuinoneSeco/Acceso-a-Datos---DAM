package org.educa.ut1.service;

import org.educa.ut1.dao.PaisesDAO;
import org.educa.ut1.dao.PaisesDAOImpl;
import generated.Paises;
import jakarta.xml.bind.JAXBException;
import org.xml.sax.SAXException;

import java.io.File;

public class PaisesService {
    PaisesDAO paisesDAO = new PaisesDAOImpl();

    public Paises unmarshall(String pathXml, String pathXsd) {
        try {
            return paisesDAO.getPaises(new File(pathXml), new File(pathXsd));
        } catch (JAXBException | SAXException e) {
            throw new RuntimeException(e);
        }

    }
}
