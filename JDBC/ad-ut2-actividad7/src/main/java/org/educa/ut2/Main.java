package org.educa.ut2;

import org.educa.ut2.entity.*;
import org.educa.ut2.service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SucursalService sucursalService = new SucursalService();
        CategoriaService categoriaService = new CategoriaService();
        CombustibleService combustibleService = new CombustibleService();
        EquipamientoService equipamientoService = new EquipamientoService();
        VehiculoService vehiculoService = new VehiculoService();


        // Uso de try-with-resources para cerrar automáticamente el Scanner
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Introduce una matricula: ");
            String matricula = scanner.nextLine();

            System.out.println("Introduce un bastidor: ");
            String bastidor = scanner.nextLine();

            System.out.println("Introduce una marca: ");
            String marca = scanner.nextLine();

            System.out.println("Introduce un modelo: ");
            String modelo = scanner.nextLine();

            System.out.println("Introduce un color: ");
            String color = scanner.nextLine();

            System.out.println("Introduce el año: ");
            Integer anyo = scanner.nextInt();
            scanner.nextLine();

            List<CategoriaEntity> categorias = categoriaService.findAll();

            System.out.println("Seleccione una categoria:");
            for (int i = 0; i < categorias.size(); i++) {
                System.out.println((i + 1) + ". " + categorias.get(i).getNombre());
            }

            int opcion = -1;

            CategoriaEntity categoria = null;
            while (opcion < 1 || opcion > categorias.size()) {
                System.out.print("Ingrese el número de la categoria: ");

                if (scanner.hasNextInt()) {
                    opcion = scanner.nextInt();
                    scanner.nextLine();
                    if (opcion >= 1 && opcion <= categorias.size()) {
                        categoria = categorias.get(opcion - 1);
                    } else {
                        System.out.println("Número fuera de rango. Intente nuevamente.");
                    }
                } else {
                    System.out.println("Entrada inválida. Debe ingresar un número.");
                    scanner.next(); // limpiar entrada inválida
                }
            }

            List<SucursalEntity> sucursales = sucursalService.findAll();

            System.out.println("Seleccione una sucursal:");
            for (int i = 0; i < sucursales.size(); i++) {
                System.out.println((i + 1) + ". " + sucursales.get(i).getCalle() + "( " + sucursales.get(i).getCiudad() + " )");
            }

            opcion = -1;

            SucursalEntity sucursal = null;
            while (opcion < 1 || opcion > sucursales.size()) {
                System.out.print("Ingrese el número de la sucursal: ");

                if (scanner.hasNextInt()) {
                    opcion = scanner.nextInt();
                    scanner.nextLine();
                    if (opcion >= 1 && opcion <= sucursales.size()) {
                        sucursal = sucursales.get(opcion - 1);
                    } else {
                        System.out.println("Número fuera de rango. Intente nuevamente.");
                    }
                } else {
                    System.out.println("Entrada inválida. Debe ingresar un número.");
                    scanner.next(); // limpiar entrada inválida
                }
            }

            List<CombustibleEntity> combustibles = combustibleService.findAll();

            System.out.println("Seleccione un combustible:");
            for (int i = 0; i < combustibles.size(); i++) {
                System.out.println((i + 1) + ". " + combustibles.get(i).getNombre());
            }

            opcion = -1;

            CombustibleEntity combustible = null;
            while (opcion < 1 || opcion > sucursales.size()) {
                System.out.print("Ingrese el número del combustible: ");

                if (scanner.hasNextInt()) {
                    opcion = scanner.nextInt();
                    scanner.nextLine();
                    if (opcion >= 1 && opcion <= combustibles.size()) {
                        combustible = combustibles.get(opcion - 1);
                    } else {
                        System.out.println("Número fuera de rango. Intente nuevamente.");
                    }
                } else {
                    System.out.println("Entrada inválida. Debe ingresar un número.");
                    scanner.next(); // limpiar entrada inválida
                }
            }


            List<EquipamientoEntity> equipamientos = equipamientoService.findAll();

            System.out.println("Seleccione el equipamiento:");
            for (int i = 0; i < equipamientos.size(); i++) {
                System.out.println((i + 1) + ". " + equipamientos.get(i).getNombre());
            }

            List<EquipamientoEntity> equipamientoElegido = new ArrayList<>();
            System.out.print("Ingrese los equipamientos separados por coma y sin espacio: ");

            String equip = scanner.nextLine();
            String[] arrayEquip = equip.split(",");
            for (String s : arrayEquip) {
                opcion = Integer.parseInt(s);
                if (opcion >= 1 && opcion <= arrayEquip.length) {
                    EquipamientoEntity equipamientoEntity = equipamientos.get(opcion - 1);
                    equipamientoElegido.add(equipamientoEntity);
                }
            }

            assert categoria != null;
            assert sucursal != null;
            assert combustible != null;
            VehiculoEntity vehiculo = new VehiculoEntity(null, matricula,
                    bastidor, marca, modelo,
                    color, anyo, categoria.getIdCategoria(), sucursal.getId(),
                    combustible.getId(), equipamientoElegido);

            vehiculoService.insert(vehiculo);
        }

        System.out.println("FIN");


    }
}