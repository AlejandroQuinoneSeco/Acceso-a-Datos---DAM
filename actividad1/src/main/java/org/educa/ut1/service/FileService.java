package org.educa.ut1.service;

import org.educa.ut1.dao.FileDAO;
import org.educa.ut1.dao.FileDAOImpl;
import org.educa.ut1.entity.FileEntity;

import java.util.List;

public class FileService {
    private final FileDAO fileDAO = new FileDAOImpl();

    public List<FileEntity> listFile(String path) {
        return fileDAO.listFileDAO(path);

    }
}
