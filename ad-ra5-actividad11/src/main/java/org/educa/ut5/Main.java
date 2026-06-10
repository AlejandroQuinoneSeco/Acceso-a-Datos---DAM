package org.educa.ut5;

import org.educa.ut5.entity.UsuarioEntity;
import org.educa.ut5.service.UsuariosService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("Introduce el ID del usuario:");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("Introduce el nombre:");
            String name = sc.nextLine();
            System.out.println("Introduce el mail:");
            String mail = sc.nextLine();
            System.out.println("Introduce el telefono:");
            String phone = sc.nextLine();
            UsuariosService usuariosService = new UsuariosService();
            UsuarioEntity usuario = new UsuarioEntity(id, name, mail, phone, true);
            Integer insertedId = usuariosService.save(usuario);
            if (insertedId > 0) {
                System.out.println("Usuario insertado con ID: " + insertedId);
            } else {
                System.out.println("Usuario no insetado");
            }
        }
    }
}