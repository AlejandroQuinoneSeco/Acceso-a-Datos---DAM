package org.educa.ut1.dao;

import org.educa.ut1.entity.FileEntity;

import java.util.List;

public interface FileDAO {
    List<FileEntity> listFileDAO(String path);
}
