package org.educa.ut1;

import org.educa.ut1.entity.DataEntity;
import org.educa.ut1.service.DataService;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Crear servicio
        DataService dataService = new DataService();
        //Obtener la info de teclado
        try (Scanner sc = new Scanner(System.in)) {
            //Crear una entidad con los datos que yo necesito,
            // previamente he de recibir los datos por teclado
            System.out.println("Introduce el nombre del directorio donde creaar el fichero");
            String path = sc.nextLine();
            System.out.println("Introduce el nombre del fichero con la extensión");
            String name = sc.nextLine();
            System.out.println("Introduce el texto del fichero");
            String text = sc.nextLine();
            DataEntity dataEntity = new DataEntity(path, name, text);
            //Crear fichero
            dataService.createFile(dataEntity);
            //Escribir en fichero
            dataService.writeData(dataEntity);
            //Leer de fichero
            String fileContent = dataService.readData(dataEntity);
            System.out.println(fileContent);
        }
    }
}