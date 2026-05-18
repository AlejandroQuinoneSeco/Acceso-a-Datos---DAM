package org.educa.ut1.dao;

import org.educa.ut1.entity.FileEntity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileDAOImpl implements FileDAO {

    public List<FileEntity> listFileDAO(String path) {
        File directory = new File(path);
        File[] files = directory.listFiles();
        List<FileEntity> fileEntities = new ArrayList<>();
        if (files != null) {
            for (File file : files) {
                FileEntity fileEntity = new FileEntity(file.getName());
                if (file.isDirectory()) {
                    fileEntity.setType("directory");
                } else {
                    fileEntity.setType("file");
                }
                fileEntities.add(fileEntity);
            }
        }
        return fileEntities;
    }
}
