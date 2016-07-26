package com.alcoshop.database.mysqldatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by prulov on 23.07.2016.
 */
public class DB_MySQL_Worker {

    private final String URL = "jdbc:mysql://localhost:3306/alcoshop?useSSL=false";
    private final String USERNAME = "root";
    private final String PASSWORD = "89082d6PRDB";

    private Connection connection;


    public DB_MySQL_Worker(){
        try{
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("DB \"alcoshop\" connection is successfully established!");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
