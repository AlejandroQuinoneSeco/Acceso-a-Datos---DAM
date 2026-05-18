package org.educa.ut1.dao;

import org.educa.ut1.entity.DataEntity;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataDAOImpl implements DataDAO {

    @Override
    public void saveInfoInFile(File file, List<DataEntity> dataEntities) {
        try(FileWriter fileWriter = new FileWriter(file)){
            for (DataEntity dataEntity :  dataEntities) {
                fileWriter.write(dataEntity.toPrint());
                fileWriter.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<DataEntity> loadFile(File path) {
        List<DataEntity> dataEntities = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String row;
            while ((row = br.readLine())!=null){
                String[] dataRow = row.split(";");
                DataEntity dataEntity = new DataEntity(dataRow[0], dataRow[1], Long
                        .valueOf(dataRow[3]));
                String permissions = dataRow[2];
                if (permissions.contains("X")){
                    dataEntity.getPermissions().add("X");
                }
                if (permissions.contains("R")){
                    dataEntity.getPermissions().add("R");
                }
                if (permissions.contains("W")){
                    dataEntity.getPermissions().add("W");
                }

                dataEntities.add(dataEntity);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dataEntities;
    }
}
