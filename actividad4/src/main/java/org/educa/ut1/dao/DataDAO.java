package org.educa.ut1.dao;

import java.io.File;
import java.util.List;

public interface DataDAO {
    List<Integer> readAllIntegers(File file);

    void addInteger(int numero, File file);
}
