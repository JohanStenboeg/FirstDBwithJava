package StenboegJohan;

import java.sql.*;

public class DB_Statements {


    //Declare a Statement
    private static Statement stmt = null;

    //Declare a connection
    private static Connection con = DB_Connector.connect();

    //Declare a result set
    private static ResultSet rs = null;

    //    Method to create a new Database
    public void createNewDB(String DB_Name) {
        //SQL statement

        String query = "create database if not exists " + DB_Name;

        try {
            //Cnnection
            stmt = con.createStatement();

//    Execute  statement
            stmt.executeUpdate(query);
            System.out.println("\n--Database named: " + DB_Name + " created--");
        } catch (SQLException ex) {
            //Handle sql exceptions (try/catch)
            System.out.println("\n--Statement did not execute--");
            ex.printStackTrace();
        }
    }

    //method to use a database
    public void useDB(String DB_Name) {
        //Statement
        String query = "use " + DB_Name;
        try {
            //Connection
            stmt = con.createStatement();
            //execute query
            stmt.executeUpdate(query);
            //To know if successfull. If yes this will print.
            System.out.println("\n--using " + DB_Name + "--");
        } catch (SQLException ex) {
            //handle sql exeptions
            System.out.println("{\n--Query did not execute--");
            ex.printStackTrace();
        }
    }

    public void createTable(String tableName) {
        //SQL Statement
        String query = "create table if not exists " +
                tableName +
                "(" +
                "id int not null auto_increment, " +
                "firstName varchar(30)," +
                "lastName varchar(30)," +
                "address varchar(30)," +
                "primary key (id)" +
                ")";
        try {
            //connection
            stmt = con.createStatement();
            //execute query
            stmt.executeUpdate(query);
            //To know if sucsessfull
            System.out.println("\n--Table " + tableName + " created successfully");
        } catch (SQLException ex) {
            //handle sql exeptions
            System.out.println("{\n--Query did not execute in create table--");
            ex.printStackTrace();
        }
    }

    //Metod to insert data
    public void insertData(String tableName) {
        //Sql statement
        String query = "insert into " +
                tableName +
                "(" +
                "firstName, lastName, Address) " +
                "values ('Johan','Stenbøg','Skovridergårdsvej 2'), " +
                "('Per ', 'Stenbøg', 'Skovridergårdsvej 2'), " +
                "('Rose', 'Stenbøg', 'Skovridergårdsvej 2')";
        try {
            //Connection
            stmt = con.createStatement();
            //Execute query
            stmt.executeUpdate(query);
            //To know if sucsessfull
            System.out.println("\n--Values inserted into table " + tableName + " successfull--");

        } catch (SQLException ex) {
            //handle sql exeptions
            System.out.println("{\n--Query did not execute in inserting values into table " + tableName + "--");
            ex.printStackTrace();
        }
    }

    //Method to read data from table
    public void selectFromTable(String tableName) {
        //SQL Statement
        String query = "select * from " + tableName;
        try {
            //Connection
            stmt = con.createStatement();
            //Execute query
            rs = stmt.executeQuery(query);
            System.out.println("id\t\tfirstName\t\tlastName\t\tAddress\n____________________________________________________________");
            //Get data
            while(rs.next()) {
                int id = rs.getInt(1); //returns the id
                String firstName = rs.getString("firstName"); //returns firstName
                String lastName = rs.getString("lastName"); //returns lastName
                String address = rs.getString("address"); //returns address
                System.out.println(id + "\t\t" + firstName + "\t\t" + lastName + "\t\t" + address);
            }
        } catch (SQLException ex) {
            //handle sql exeptions
            System.out.println("\n--Query did not execute in getting data from " + tableName + "--");
            ex.printStackTrace();

        }

    }

    public Boolean checkLogin(String username, String password){
        boolean check = false;

        String query = "select * from thisdatabase.user where username = '" + username + "' and password '" + password + "' ";
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next()){
                check = true;
                System.out.println("\n--YOOHOOOO!!! It actually works for once!!--");
            }
        } catch (SQLException e) {
            System.out.println("\n--fucks sake it dosn't fucking work this fucking shitty fucking program--");
            e.printStackTrace();
        }
        return check;
    }
}
