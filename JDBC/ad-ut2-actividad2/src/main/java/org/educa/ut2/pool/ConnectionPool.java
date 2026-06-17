package org.educa.ut2.pool;

import org.apache.commons.dbcp.BasicDataSource;

public class ConnectionPool {

    private static final String DATABASE = "postgres";
    private static final String HOST = "localhost";
    private static final String PORT = "25432";
    private static final String SCHEMA = "public";
    private static final String USER = "postgres";
    private static final String PASS = "2DAMV2425";

    private static final String URL_CONNECTION = "jdbc:postgresql://"
            + HOST + ":" + PORT + "/" + DATABASE + "?currentSchema=" + SCHEMA;

    private ConnectionPool() {
        throw new IllegalStateException();
    }

    private static BasicDataSource basicDataSource;

    public static BasicDataSource getDataSource() {
        if (basicDataSource == null) {
            basicDataSource = new BasicDataSource();
            basicDataSource.setUrl(URL_CONNECTION);
            basicDataSource.setUsername(USER);
            basicDataSource.setPassword(PASS);
            basicDataSource.setMinIdle(5);
            basicDataSource.setMaxIdle(10);
        }
        return basicDataSource;
    }
}
