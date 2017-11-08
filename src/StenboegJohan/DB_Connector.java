package StenboegJohan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connector {

    //declare a connection
    private static Connection con = null;

    //JDBC driver
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    //The url = jdbc:dbms//host name:port#/db name
    private static String url = "jdbc:mysql://localhost:3306/";

    //Username
    private static String username = "root";

    //Password
    private static String password = "192837";

    public static Connection connect() {

        System.out.println("\n--Connection to MySQL JDBC");

        //Locate MySQL JDBC Driver
        try {
            Class.forName(DRIVER);

        }

        //Catch execptions if JDBC is not found
        catch (ClassNotFoundException ex) {

            ex.printStackTrace();

            System.out.println("\n--JDBC driver is missing--");
        }

        System.out.println("\n--MySQL JDBC driver registered--");

        //Connect to MySQL DB = URL, Username % password
        try {
            con = DriverManager.getConnection(url, username, password);

        } catch (SQLException ex) {

            ex.printStackTrace();

            System.out.println("\n--Did not connect try again--");
        }
        //If connecting successful
        if (con != null) {
            System.out.println("\n--Connection successful--");
        } else {
            //If connection failed
            System.out.println("\n--Failed to connect--");
        }
        return con;

    }
}


//Catch exceptions if connection error
