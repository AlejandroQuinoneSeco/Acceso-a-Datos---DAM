package org.educa.ut5;

import org.educa.ut5.entity.UsuarioEntity;
import org.educa.ut5.service.UsuariosService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        UsuariosService usuariosService = new UsuariosService();
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("Introduce el ID del usuario:");
            int id = sc.nextInt();
            sc.nextLine();
            Long numDeleted = usuariosService.delete(id);
            System.out.println("Usuarios eliminados: " + numDeleted);
        }
    }
}