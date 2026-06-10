package org.educa.ut5;

import org.educa.ut5.entity.PrestamoEntity;
import org.educa.ut5.service.PrestamosService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        PrestamosService prestamosService = new PrestamosService();
        List<PrestamoEntity> prestamos = prestamosService.findAll();
        for (PrestamoEntity prestamo :  prestamos) {
            System.out.println(prestamo);
        }
    }
}