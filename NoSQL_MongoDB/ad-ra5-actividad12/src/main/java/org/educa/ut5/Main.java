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
            UsuarioEntity usuario = usuariosService.findById(id);
            System.out.println("El nombre actual del usuairo es: " + usuario.getNombre());
            System.out.println("Introduce el nuevo nombre");
            String name = sc.nextLine();
            usuario.setNombre(name);
            usuariosService.update(usuario);
        }
    }
}