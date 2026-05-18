package org.educa.ut1.dao;

import org.educa.ut1.entity.DataEntity;

import java.io.File;
import java.util.List;

public interface DataDAO {
    void saveInfoInFile(File file, List<DataEntity> dataEntities);

    List<DataEntity> loadFile(File path);
}
