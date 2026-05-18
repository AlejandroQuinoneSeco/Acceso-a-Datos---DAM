package org.educa.ut1.service;

import org.educa.ut1.dao.DataDAO;
import org.educa.ut1.dao.DataDAOImpl;
import org.educa.ut1.entity.DataEntity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DataService {
    private final DataDAO dataDAO = new DataDAOImpl();

    public void splitFile(String path, String pathFile, String pathDirectory) {
        List<DataEntity> infoFile = dataDAO.loadFile(new File(path));
        List<DataEntity> files = new ArrayList<>();
        List<DataEntity> directories = new ArrayList<>();
        for(DataEntity dataEntity : infoFile){
            if (dataEntity.getType().equalsIgnoreCase("F")){
                files.add(dataEntity);
            } else {
                directories.add(dataEntity);
            }
        }
        dataDAO.saveInfoInFile(new File(pathFile), files);
        dataDAO.saveInfoInFile(new File(pathDirectory), directories);
    }
}
