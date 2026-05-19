package org.educa.ut1.dao;

import generated.Paises;
import jakarta.xml.bind.JAXBException;
import org.xml.sax.SAXException;

import java.io.File;

public interface PaisesDAO {
    Paises getPaises(File xml, File xsd) throws JAXBException, SAXException;
}
