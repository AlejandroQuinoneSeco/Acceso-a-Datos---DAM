package org.educa.ut1;

import generated.Pais;
import generated.Paises;
import org.educa.ut1.service.PaisesService;

public class Actividad1 {
    private static final String PATH_XML = "src/main/resources/xml/actividad1.xml";
    private static final String PATH_XSD = "src/main/resources/xsd/actividad1.xsd";

    public static void main(String[] args) {
        PaisesService paisesService = new PaisesService();
        Paises paises = paisesService.unmarshall(PATH_XML, PATH_XSD);
        for (Pais pais : paises.getPais()) {
            System.out.println("Nombre: " + pais.getNombre());
            System.out.println("Capital: " + pais.getCapital());
            System.out.println("Poblacion: " + pais.getPoblacion());
            System.out.println("==========================================");
        }
    }
}
