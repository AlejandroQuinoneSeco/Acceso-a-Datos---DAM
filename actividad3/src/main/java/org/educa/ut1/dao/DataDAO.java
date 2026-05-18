package org.educa.ut1.dao;

import org.educa.ut1.entity.DataEntity;

import java.io.File;
import java.io.IOException;

public interface DataDAO {
    void writeFile(DataEntity dataEntity);

    String readFile(DataEntity dataEntity);

    void createFile(File file) throws Exception;
}
