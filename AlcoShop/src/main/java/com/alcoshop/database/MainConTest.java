package com.alcoshop.database;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by prulov on 22.07.2016.
 */
public class MainConTest {

    private static final String URL = "jdbc:mysql://localhost:3306/alcoshop";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "89082d6PRDB";

    public static void main(String[] args) {

        Connection connection = null;
        try{
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if(!connection.isClosed()){
                System.out.println("DB \"alcoshop\" connection is successfully established!");
            }
        }catch(SQLException e){
            System.err.println("Driver class couldn't be uploaded!");
        }finally{
            if (connection != null){
                try
                {
                    connection.close ();
                    System.out.println ("Database connection terminated");
                }catch (Exception e){
                    /* ignore close errors */
                }
            }
        }
    }
}
