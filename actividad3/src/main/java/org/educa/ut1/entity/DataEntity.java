package org.educa.ut1.entity;

import java.io.File;

public class DataEntity {
    private File file;
    private String text;

    public DataEntity(String path, String name, String text) {
        this.file = new File(path+name);
        this.text = text;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
