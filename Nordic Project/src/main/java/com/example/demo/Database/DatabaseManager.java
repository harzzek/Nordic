package com.example.demo.Database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DatabaseManager
{

    private static String url;
    private static String user;
    private static String password;

    public static Connection getConnection(){
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
        Connection connection = null;
        if(connection != null) return connection;
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("Nordic Project/src/main/resources/application.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties prop = new Properties();
        try {
            prop.load(inputStream);
            user = prop.getProperty("spring.datasource.username");
            password = prop.getProperty("spring.datasource.password");
            url = prop.getProperty("spring.datasource.url");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            //jdbc:mysql://HOST/DATABASE
            connection =  DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println( "\n" + url + "" + user + "" + password);
        }
        return connection;
    }

    public static void closeCon(ResultSet rs, PreparedStatement statement, Connection connection) throws SQLException {
        rs.close();
        statement.close();
        connection.close();
    }

    public static void closeCon(PreparedStatement statement, Connection connection) throws SQLException {
        statement.close();
        connection.close();
    }

    public static void closeCon(Connection connection) throws SQLException {
        connection.close();
    }

}
