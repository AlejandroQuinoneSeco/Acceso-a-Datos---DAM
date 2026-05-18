package org.educa.ut1.dao;

import org.educa.ut1.entity.DataEntity;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class DataDAOImpl implements DataDAO {
    @Override
    public void createFile(File file, List<DataEntity> dataEntities) {

        try (PrintWriter printWriter = new PrintWriter(file)) {
            for (DataEntity dataEntity : dataEntities) {
                printWriter.println(dataEntity.toPrint());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
