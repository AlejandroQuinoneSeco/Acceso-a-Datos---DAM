package org.educa.ut2;

import org.educa.ut2.service.VehiculoService;

public class Main {
    public static void main(String[] args) {
        VehiculoService vehiculoService = new VehiculoService();

        vehiculoService.deleteAllVehiculoBefore(2014);

        System.out.println("FIN");


    }
}