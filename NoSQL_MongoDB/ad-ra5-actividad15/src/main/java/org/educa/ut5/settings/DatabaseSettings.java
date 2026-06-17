package org.educa.ut5.settings;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseSettings {

    private DatabaseSettings(){
        throw new IllegalStateException();
    }

    private static Properties getProperties() {
        Properties properties = new Properties();
        try (InputStream is = DatabaseSettings.class.getClassLoader()
                .getResourceAsStream("database.properties")){
            properties.load(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }

    public static String getURL(){
        Properties properties = getProperties();
        return properties.getProperty("db.url");
    }

    public static String getDB(){
        Properties properties = getProperties();
        return properties.getProperty("db.name");
    }

}
