package org.educa.ut1.service;

import org.educa.ut1.dao.FileDAO;
import org.educa.ut1.dao.FileDAOImpl;
import org.educa.ut1.entity.FileEntity;

import java.io.File;
import java.util.List;

public class FileService {
    private final FileDAO fileDAO = new FileDAOImpl();
    public void renameFileWithPermision(String path) {
        List<FileEntity> files = fileDAO.listFileDAO(path);
        for (FileEntity fileEntity : files){
            //renombrar
            fileDAO.renameTo(fileEntity);
        }
    }


}