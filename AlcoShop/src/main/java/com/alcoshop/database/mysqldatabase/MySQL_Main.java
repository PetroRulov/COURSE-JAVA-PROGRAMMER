package com.alcoshop.database.mysqldatabase;

import domain.Client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by prulov on 23.07.2016.
 */
public class MySQL_Main {

    public static void main(String[] args) {

        DB_MySQL_Worker mySQLWorker = new DB_MySQL_Worker();

        String clientsQuery = "select * from clients where id_client > 5";
        
        try {
            Statement statement = mySQLWorker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(clientsQuery);

            while(resultSet.next()){
                Client sql = new Client();
                sql.setId_client(resultSet.getInt(1));
                sql.setSurName(resultSet.getString(2));
                sql.setName(resultSet.getString(3));
                sql.setDateOfBirth(resultSet.getString(4));
                sql.setSex(resultSet.getString(5));
                sql.seteMail(resultSet.getString("email"));
                System.out.println(sql);


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
