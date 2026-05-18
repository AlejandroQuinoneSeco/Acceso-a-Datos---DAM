package org.educa.ut1.service;

import org.educa.ut1.dao.DataDAO;
import org.educa.ut1.dao.DataDAOImpl;
import org.educa.ut1.entity.DataEntity;

import java.io.File;

public class DataService {
    private final DataDAO dataDAO = new DataDAOImpl();

    public void createFile(DataEntity data) {
        File file = data.getFile();
        try {
            dataDAO.createFile(file);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public void writeData(DataEntity dataEntity) {
        dataDAO.writeFile(dataEntity);
    }

    public String readData(DataEntity dataEntity) {
        return dataDAO.readFile(dataEntity);
    }
}
