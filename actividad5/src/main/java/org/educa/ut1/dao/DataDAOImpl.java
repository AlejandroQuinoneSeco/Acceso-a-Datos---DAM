package org.educa.ut1.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class DataDAOImpl implements DataDAO {
    @Override
    public List<Integer> readAllIntegers(File file) {
        List<Integer> enteros = new ArrayList<>();
        try(RandomAccessFile raf = new RandomAccessFile(file, "r")){
            while (!isEOF(raf)){
                enteros.add(raf.readInt());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return enteros;
    }

    @Override
    public void addInteger(int numero, File file) {
        try(RandomAccessFile raf = new RandomAccessFile(file, "rw")){
            raf.seek(raf.length());
            raf.writeInt(numero);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void replaceInteger(int posicion, int numero, File file) {
        try(RandomAccessFile raf = new RandomAccessFile(file, "rw")){
            raf.seek((posicion-1) * 4L);
            raf.writeInt(numero);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isEOF(RandomAccessFile raf) throws IOException {
        return raf.length() == raf.getFilePointer();
    }
}
