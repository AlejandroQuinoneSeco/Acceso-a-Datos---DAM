package org.educa.ut1.service;

import org.educa.ut1.dao.DataDAO;
import org.educa.ut1.dao.DataDAOImpl;

import java.io.File;
import java.util.List;

public class DataService {
    private final DataDAO dataDAO = new DataDAOImpl();

    public List<Integer> readFile(String filePath) {
        File file = new File(filePath);
        return dataDAO.readAllIntegers(file);
    }

    public void addInteger(int numero, String filePath) {
        File file = new File(filePath);
        dataDAO.addInteger(numero, file);
    }
}
