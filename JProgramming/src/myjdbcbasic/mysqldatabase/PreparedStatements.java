package myjdbcbasic.mysqldatabase;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.*;
import java.util.Calendar;

public class PreparedStatements {

    private static final String URL = "jdbc:mysql://localhost:3306/alcoshop?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "89082d6PRDB";

    private static final String INSERT_NEW = "INSERT INTO clients(id_client, surName, name, dateOfBirth, sex, email)" +
            " VALUES(?, ?, ?, ?, ?, ?);";
    private static final String DELETE_SOME_CLIENT = "DELETE FROM clients WHERE id_client = ?";

    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            preparedStatement = connection.prepareStatement(DELETE_SOME_CLIENT);
            preparedStatement.setInt(1, 1);
            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement(INSERT_NEW);
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, "Makarov");
            preparedStatement.setString(3, "Ivan");
            preparedStatement.setString(4, "10/10/1990");
            preparedStatement.setString(5, "male");
            preparedStatement.setString(6, "none");
            //preparedStatement.setDate(7, new Date(Calendar.getInstance().getTimeInMillis()));
            //preparedStatement.setBigDecimal(7, new BigDecimal(5.0));
            //preparedStatement.setBlob(7, new FileInputStream("addClient.gif"));
            preparedStatement.execute();


            //}catch(SQLException  | FileNotFoundException e){
        }catch(SQLException e){

            e.printStackTrace();
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
