package org.educa.ut1.dao;

import org.educa.ut1.entity.DataEntity;

import java.io.*;

public class DataDAOImpl implements DataDAO {
    @Override
    public void writeFile(DataEntity dataEntity) {
        try (FileWriter fileWriter = new FileWriter(dataEntity.getFile())){
            fileWriter.write(dataEntity.getText());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String readFile(DataEntity dataEntity) {
        try(FileReader fileReader = new FileReader(dataEntity.getFile());
            BufferedReader br = new BufferedReader(fileReader)){
            String line;
            String text = "";
            while ((line = br.readLine()) != null){
                text += line + "\n";
            }
            return text;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createFile(File file) throws Exception {
        if (!file.createNewFile()){
            throw new Exception("El fichero no ha podido ser creado");
        }
    }
}
