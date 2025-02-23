package com.javaproject.hungrybarfinal.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfiguration {
    public static final String URL = "jdbc:mysql://localhost:3306/hungrybarfinal?zeroDateTimeBehavior=CONVERT_TO_NULL";
    public static final String USER = "root";
    public static final String PASSWORD = "shehan@2002";
    
    public static Connection getConnection() throws SQLException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
