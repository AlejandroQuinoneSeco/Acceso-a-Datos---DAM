package org.educa.ut1.service;

import org.educa.ut1.dao.DataDAO;
import org.educa.ut1.dao.DataDAOImpl;
import org.educa.ut1.entity.DataEntity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DataService {
    private final DataDAO dataDAO = new DataDAOImpl();

    public void createInfo(String fileName, String path) {
        File folder = new File(path);
        if (folder.exists() && folder.isDirectory()) {
            List<DataEntity> dataEntities = loadInfoFromPath(folder.listFiles());
            dataDAO.createFile(new File(fileName), dataEntities);
        }
    }

    private List<DataEntity> loadInfoFromPath(File[] path) {
        List<DataEntity> dataEntities = new ArrayList<>();
        for (File file : path) {
            DataEntity dataEntity = new DataEntity();
            dataEntity.setName(file.getName());
            String type = file.isDirectory() ? "D" : "F";
            dataEntity.setType(type);
            if (file.canExecute()) {
                dataEntity.getPermissions().add("X");
            }
            if (file.canWrite()) {
                dataEntity.getPermissions().add("W");
            }
            if (file.canRead()) {
                dataEntity.getPermissions().add("R");
            }
            dataEntity.setSize(file.length());
            dataEntities.add(dataEntity);
        }
        return dataEntities;
    }
}
