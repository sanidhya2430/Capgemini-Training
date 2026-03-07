package com.capgi.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class PlayerRepository {
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cap_player",
                    "root",
                    "root"
            );
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
