package org.educa.ut1;

import org.educa.ut1.service.DataService;

public class Main {
    private static final String PATH = "src/main/resources/result.txt";
    private static final String PATH_FILE = "src/main/resources/files.txt";
    private static final String PATH_DIRECTORY = "src/main/resources/directories.txt";
    public static void main(String[] args) {
        DataService dataService = new DataService();
        dataService.splitFile(PATH, PATH_FILE, PATH_DIRECTORY);
    }
}