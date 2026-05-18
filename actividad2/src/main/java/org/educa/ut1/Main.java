package org.educa.ut1;

import org.educa.ut1.service.FileService;

public class Main {
    private static final String PATH = "/home/profesor/prueba";
    public static void main(String[] args) {
        FileService fileService = new FileService();
        fileService.renameFileWithPermision(PATH);
    }
}