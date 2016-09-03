package com.alcoshop.database;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class MainStatQuerry {

    private static final String URL = "jdbc:mysql://localhost:3306/alcoshop?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "89082d6PRDB";

    public static void main(String[] args) {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try(
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                Statement statement = connection.createStatement();
        ){
            System.out.println(connection.isClosed());

            String sql = "INSERT INTO clients(id_client, surName, name, dateOfBirth, sex, email) VALUES(1, 'Po', 'Edgar', '07/11/1877', 'male', 'interneta@eshyo.net');";
            statement.execute(sql);
            //statement.executeUpdate("update clients set surName = 'HoPo' where id_client = 1;");

//            ResultSet result = statement.executeQuery("select * from clients");

            statement.addBatch("insert into clients (id_client, surName, name, dateOfBirth, sex, email)" +
                    "values(2, 'Lennon', 'John', '17/07/1957', 'male', 'jholen57@beathles.eng')");
            statement.addBatch("insert into clients (id_client, surName, name, dateOfBirth, sex, email)" +
                    "values(3, 'MacCarthney', 'Pol', '07/07/1957', 'male', 'polmac@beathles.eng')");
            statement.executeBatch();
//            statement.clearBatch();

//            boolean connStatus = statement.isClosed();
//            System.out.println(connStatus);

//            statement.getConnection();

//            statement.close();

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
