package org.educa.ut2;

import org.educa.ut2.entity.VehiculoEntity;
import org.educa.ut2.service.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SucursalService sucursalService = new SucursalService();
        CombustibleService combustibleService = new CombustibleService();
        EquipamientoService equipamientoService = new EquipamientoService();
        VehiculoService vehiculoService = new VehiculoService();

        List<VehiculoEntity> vehiculoEntities = new ArrayList<>();

        VehiculoEntity vehiculo1 = new VehiculoEntity(null, "1234XZW",
                "MHJGS99U857412578", "Volkswagen", "Golf",
                "Blanco", 2020, 3, sucursalService.findIdByCalleYCiudad("Av. Andalucía 10", "Sevilla"),
                combustibleService.findIdByNombre("Diésel"), equipamientoService.findListaEquipamientos("Climatizador", "GPS", "Elevalunas eléctrico"));
        vehiculoEntities.add(vehiculo1);

        VehiculoEntity vehiculo2 = new VehiculoEntity(null, "5678ABC",
                "UYHJF88R785112336", "Seat", "Altea",
                "Azul", 2024, 4, sucursalService.findIdByCalleYCiudad("Av. Galicia 50", "Vigo"),
                combustibleService.findIdByNombre("Gasolina"), equipamientoService.findListaEquipamientos("Climatizador", "GPS", "Elevalunas eléctrico", "Bluetooth", "Airbags", "ABS"));
        vehiculoEntities.add(vehiculo2);

        VehiculoEntity vehiculo3 = new VehiculoEntity(null, "9999MMP",
                "TREWH77W752468951", "Opel", "Insignia",
                "Negro", 2024, 5, sucursalService.findIdByCalleYCiudad("Calle Castilla 9", "Santander"),
                combustibleService.findIdByNombre("Diésel"), equipamientoService.findAllEquipamientos());
        vehiculoEntities.add(vehiculo3);

        vehiculoService.insertAll(vehiculoEntities);

        System.out.println("FIN");


    }
}