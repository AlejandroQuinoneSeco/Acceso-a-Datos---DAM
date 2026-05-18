package org.educa.ut1;

import org.educa.ut1.entity.FileEntity;
import org.educa.ut1.service.FileService;

import java.util.List;

public class Main {
    private static final String PATH = "/etc";
    public static void main(String[] args) {
        FileService fileService = new FileService();
        List<FileEntity> files = fileService.listFile(PATH);
        for (FileEntity fileEntity : files) {
            System.out.println("The file " + fileEntity.getName() + " is a " + fileEntity.getType());
        }
    }
}