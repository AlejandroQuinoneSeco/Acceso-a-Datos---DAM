package org.educa.ut1.dao;

import org.educa.ut1.entity.FileEntity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileDAOImpl implements FileDAO {

    public List<FileEntity> listFileDAO(String path) {
        File directory = new File(path);
        File[] files = directory.listFiles();
        List<FileEntity> fileEntities = new ArrayList<>();
        if (files != null) {
            for (File file : files) {
                FileEntity fileEntity = new FileEntity(file.getName(), file);
                if (file.isDirectory()) {
                    fileEntity.setType("directory");
                } else {
                    fileEntity.setType("file");
                }
                setPermissions(fileEntity);
                createPathWithExtensions(fileEntity);
                fileEntities.add(fileEntity);
            }
        }
        return fileEntities;
    }

    @Override
    public void renameTo(FileEntity fileEntity) {
        File file = fileEntity.getFile();
        file.renameTo(new File(fileEntity.getPath()));
    }

    private void setPermissions(FileEntity fileEntity) {
        //permisos
        String permission = "";
        File file = fileEntity.getFile();
        permission = file.canRead() ? permission + "R" : permission;
        permission = file.canWrite() ? permission + "W" : permission;
        permission = file.canExecute() ? permission + "X" : permission;
        fileEntity.setPermissions(permission);
    }

    private void createPathWithExtensions(FileEntity fileEntity) {
        File file = fileEntity.getFile();
        int i = file.getAbsolutePath().lastIndexOf(".");
        if (i > 0){
            String extension = file.getAbsolutePath().substring(i);
            String pathWithoutExtension = file.getAbsolutePath().substring(0, i);
            String fullPath = pathWithoutExtension + fileEntity.getPermissions() + extension;
            fileEntity.setPath(fullPath);
        } else {
            String fullPath = file.getAbsolutePath() + fileEntity.getPermissions();
            fileEntity.setPath(fullPath);
        }
    }
}
