package org.educa;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido/a al programa de alquileres.");
        Console console = new Console();
        try {
            console.init();
        } catch (Exception e) {
            System.err.println("Se ha producido una excepción");
            throw new RuntimeException(e);
        }
    }
}