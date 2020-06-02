package com.example.demo.Database;

import com.example.demo.Model.Customers.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerMapper
{
    PreparedStatement statement;
    Connection connection;
    DatabaseManager db = new DatabaseManager();
    public void create(Customer customer) {
        try {
            connection = DatabaseManager.getConnection();
            String sql = "INSERT INTO customers Values(?,?,?,?)";
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setInt(1,customer.getCustomerPhone());
            statement.setString(2,customer.getCustomerFname());
            statement.setString(3,customer.getCustomerLname());
            statement.setString(4,customer.getCustomerEmail());
            statement.execute();
            db.closeCon(statement,connection);
        } catch (SQLException e)
        {
            System.out.println(e);
        }
    }


    public void delete() {

    }


    public void update() {

    }


    public ArrayList<Customer> list() {
        ArrayList<Customer> customerList = new ArrayList();
        try {
            connection = DatabaseManager.getConnection();
            String sqlQuary1 = "SELECT * from customers";
            statement = connection.prepareStatement(sqlQuary1);
            ResultSet rs = statement.executeQuery();

            while (rs.next())
            {
                int customerPhone = rs.getInt("customerPhone");
                String fname = rs.getString("customerFname");
                String lname = rs.getString("customerLname");
                String email = rs.getString("customerEmail");

                customerList.add(new Customer(customerPhone, fname, lname, email));
            }
            db.closeCon(rs,statement,connection);

        } catch (SQLException e)
        {
            System.out.println(e);
        }

        return customerList;
    }


    public Customer find(int phoneNr) {
        ResultSet rs;
        Customer theCustomer = null;
        try {
            connection = DatabaseManager.getConnection();
            String sql = "SELECT * from customers where customerPhone = ?";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1,phoneNr);

            rs = statement.executeQuery();
            while (rs.next())
            {
                int customerPhone = rs.getInt("customerPhone");
                String fname = rs.getString("customerFname");
                String lname = rs.getString("customerLname");
                String email = rs.getString("customerEmail");

                theCustomer = new Customer(customerPhone,fname,lname,email);
            }
            db.closeCon(rs,statement,connection);

        } catch (SQLException e)
        {
            System.out.println(e);
        }
        return theCustomer;
    }
}
