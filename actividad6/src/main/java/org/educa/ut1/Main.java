package org.educa.ut1;

import org.educa.ut1.service.DataService;

public class Main {
    private static final String FILE_NAME = "src/main/resources/result.txt";

    public static void main(String[] args) {
        String folder = args[0];
        DataService dataService = new DataService();
        dataService.createInfo(FILE_NAME, folder);
    }
}