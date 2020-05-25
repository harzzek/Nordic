package com.example.demo.Model;

import com.example.demo.Database.CustomerMapper;

import java.util.List;

public class Customers {

    CustomerMapper customerMapper = new CustomerMapper();

    public Customer read(int phoneNr)
    {
        return customerMapper.find(phoneNr);
    }

    public List<Customer> readAll()
    {
        return customerMapper.list();
    }

    public void create(int customerPhone, String fname, String lname, String email){
        Customer customer = new Customer( customerPhone, fname, lname, email);
        customerMapper.create(customer);
    }

    public boolean update(int customerPhone, String fname, String lname, String email)
    {
        return true;
    }

    public boolean delete()
    {
        return true;
    }

    public String toString()
    {
        return "POGGERS";
    }
}
