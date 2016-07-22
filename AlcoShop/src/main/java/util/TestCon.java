package util;

import java.sql.DriverManager;

/**
 * Created by prulov on 22.07.2016.
 */
public class TestCon {

    public static void main (String[] args)
    {
        java.sql.Connection conn = null;
        try
        {
            String userName = "root";
            String password = "89082d6PRDB";
            String url = "jdbc:mysql://localhost/alcoshop";
            Class.forName ("com.mysql.jdbc.Driver").newInstance ();
            conn = DriverManager.getConnection (url, userName, password);
            System.out.println ("Database connection established");
        }
        catch (Exception e)
        {
            System.err.println ("Cannot connect to database server");
            e.printStackTrace();
        }
        finally
        {
            if (conn != null)
            {
                try
                {
                    conn.close ();
                    System.out.println ("Database connection terminated");
                }
                catch (Exception e) { /* ignore close errors */ }
            }
        }
    }
}