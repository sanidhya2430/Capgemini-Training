package org.example;

import com.mysql.cj.jdbc.Driver;
import java.sql.*;

public class Question {
    private static final String URL = "jdbc:mysql://localhost:3306/productmanagement";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }


}
