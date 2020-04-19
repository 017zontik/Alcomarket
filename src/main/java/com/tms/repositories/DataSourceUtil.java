package com.tms.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSourceUtil {
    private final static String url = "jdbc:mysql://localhost:3306/alcomarket?createDatabaseIfNotExist=true&serverTimezone=UTC";
    private final static String user = "root";
    private final static String password = "171986";

    public static  Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    public static void closeConnection(Connection conn) throws SQLException {
        conn.close();

    }


}
