package com.example.demo.Database;

import com.example.demo.Model.Customer;
import com.example.demo.Model.Customers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerMapper extends DatabaseManager
{
    PreparedStatement statement;

    public void create(Customer customer) {
        try {
            String sql = "INSERT INTO customers Values(?,?,?,?)";
            statement = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setInt(1,customer.getCustomerPhone());
            statement.setString(2,customer.getCustomerFname());
            statement.setString(3,customer.getCustomerLname());
            statement.setString(4,customer.getCustomerEmail());
            statement.execute();
        } catch (Exception e)
        {
            System.out.println(e);
        }
    }


    public void delete() {

    }


    public void update() {

    }


    public List<Customer> list() {
        ArrayList<Customer> customerList = new ArrayList();
        try {
            String sqlQuary1 = "SELECT * from customers";
            statement = getConnection().prepareStatement(sqlQuary1);
            ResultSet rs = statement.executeQuery(sqlQuary1);

            while (rs.next())
            {
                int customerPhone = rs.getInt("customerPhone");
                String fname = rs.getString("customerFname");
                String lname = rs.getString("customerLname");
                String email = rs.getString("customerEmail");

                customerList.add(new Customer(customerPhone, fname, lname, email));
            }

        } catch (Exception e)
        {
            System.out.println(e);
        }

        return customerList;
    }


    public Customer find(int phoneNr) {
        ResultSet rs;
        Customer theCustomer = null;
        try {
            String sql = "SELECT * from customers where customerPhone = ?";
            PreparedStatement statement = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1,phoneNr);

            rs = statement.executeQuery();
            while (rs.next())
            {
                int customerPhone = rs.getInt("customerPhone");
                String fname = rs.getString("customerFname");
                String lname = rs.getString("customarLname");
                String email = rs.getString("customerEmail");

                theCustomer = new Customer(customerPhone,fname,lname,email);
            }

        } catch (Exception e)
        {
            System.out.println(e);
        }
        return theCustomer;
    }
}
