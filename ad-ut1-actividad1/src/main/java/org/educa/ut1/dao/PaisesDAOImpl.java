package org.educa.ut1.dao;

import generated.Paises;
import org.educa.ut1.handler.ValidationHandler;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.validation.SchemaFactory;
import java.io.File;

public class PaisesDAOImpl implements PaisesDAO {
    @Override
    public Paises getPaises(File xml, File xsd) throws JAXBException, SAXException {;
        JAXBContext jaxbContext = JAXBContext.newInstance(Paises.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        unmarshaller.setSchema(SchemaFactory.newInstance(
                XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(xsd));
        unmarshaller.setEventHandler(new ValidationHandler());
        return (Paises) unmarshaller.unmarshal(xml);
    }
}
