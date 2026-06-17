package org.educa;

import org.educa.entity.CategoriaEntity;
import org.educa.entity.CombustibleEntity;
import org.educa.entity.SucursalEntity;
import org.educa.entity.VehiculoEntity;
import org.educa.service.CategoriaService;
import org.educa.service.CombustibleService;
import org.educa.service.SucursalService;
import org.educa.service.VehiculoService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CategoriaService categoriaService = new CategoriaService();
        SucursalService sucursalService = new SucursalService();
        CombustibleService combustibleService = new CombustibleService();
        VehiculoService vehiculoService = new VehiculoService();

        System.out.println("Hello, World!");
        System.out.println("Introduce los datos para un nuevo vehículo");
        try (Scanner sc = new Scanner(System.in)) {

            System.out.println("Introduce la matricula: ");
            String matricula = sc.nextLine();
            System.out.println("Introduce el bastidor: ");
            String bastidor = sc.nextLine();
            System.out.println("Introduce la marca: ");
            String marca = sc.nextLine();
            System.out.println("Introduce el modelo: ");
            String modelo = sc.nextLine();
            System.out.println("Introduce el color: ");
            String color = sc.nextLine();
            System.out.println("Introduce el anio: ");
            Integer anio = sc.nextInt();
            sc.nextLine();

            //categoria
            List<CategoriaEntity> categorias = categoriaService.findAll();
            for (int i = 0; i < categorias.size(); i++) {
                System.out.println(i + 1 + " - " + categorias.get(i).getNombre());
            }
            System.out.println("Elige una categoria: ");
            int categoriaIndex = sc.nextInt();
            sc.nextLine();
            CategoriaEntity categoria = categorias.get(categoriaIndex - 1);

            //sucursal
            List<SucursalEntity> sucursales = sucursalService.findAll();
            for (int i = 0; i < sucursales.size(); i++) {
                SucursalEntity sucursal = sucursales.get(i);
                System.out.println(i + 1 + " - " + sucursal.getCalle()
                        + " (" + sucursal.getCiudad() + ")");
            }
            System.out.println("Elige una sucursal: ");
            int sucursalIndex = sc.nextInt();
            sc.nextLine();
            SucursalEntity sucursal = sucursales.get(sucursalIndex - 1);
            //comb
            List<CombustibleEntity> combustibles = combustibleService.findAll();
            for (int i = 0; i < combustibles.size(); i++) {
                System.out.println(i + 1 + " - " + combustibles.get(i).getNombre());
            }
            System.out.println("Elige un combustible: ");
            int combIndex = sc.nextInt();
            sc.nextLine();
            CombustibleEntity combustible = combustibles.get(combIndex - 1);

            VehiculoEntity vehiculoEntity = new VehiculoEntity(null, matricula, bastidor, marca, modelo,
                    color, anio, categoria, sucursal, combustible);

            vehiculoService.save(vehiculoEntity);
        }
    }
}