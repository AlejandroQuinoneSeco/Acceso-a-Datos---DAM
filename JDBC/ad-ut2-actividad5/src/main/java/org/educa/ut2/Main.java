package org.educa.ut2;

import org.educa.ut2.entity.AlquilerEntity;
import org.educa.ut2.entity.ClienteEntity;
import org.educa.ut2.service.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        AlquilerService alquilerService = new AlquilerService();

        List<AlquilerEntity> alquileres = alquilerService.findByPrecioInferior(160.00);
        for (AlquilerEntity alquiler: alquileres) {
            System.out.println("ID: " +  alquiler.getIdAlquiler());
            System.out.println("Fecha Inicio: " +  alquiler.getFechaIni());
            System.out.println("Fecha Fin: " +  alquiler.getFechaFin());
            System.out.println("Cliente: " +  alquiler.getCliente().getNombre());
            System.out.println("Matricula: " +  alquiler.getVehiculo().getMatricula());
            System.out.println("Bastidor: " +  alquiler.getVehiculo().getBastidor());

            System.out.println("==============================================");
        }

        System.out.println("FIN");

    }
}