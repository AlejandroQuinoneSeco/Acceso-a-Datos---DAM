package org.educa.ut1;

import generated.Factura;
import org.educa.ut1.service.FacturasService;
import org.educa.ut1.view.Console;

public class Actividad2 {

    private static final String PATH_XML = "src/main/resources/xml/facturas.xml";
    private static final String PATH_XSD = "src/main/resources/xsd/facturas.xsd";

    public static void main(String[] args) {
        FacturasService facturasService = new FacturasService();
        Factura factura = facturasService.unmarshall(PATH_XML, PATH_XSD);
        Console console = new Console();
        console.print(factura);
    }

}
