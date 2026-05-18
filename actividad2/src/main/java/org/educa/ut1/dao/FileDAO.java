package org.educa.ut1.dao;

import org.educa.ut1.entity.FileEntity;

import java.io.File;
import java.util.List;

public interface FileDAO {
    List<FileEntity> listFileDAO(String path);

    void renameTo(FileEntity fileEntity);
}
