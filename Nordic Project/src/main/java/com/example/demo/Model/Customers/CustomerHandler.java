package com.example.demo.Model.Customers;

import com.example.demo.Database.CustomerMapper;

import java.util.List;

//Kodet af Benjamin

public class CustomerHandler
{

    CustomerMapper customerMapper = new CustomerMapper();

    public Customer read(int phoneNr)
    {
        return customerMapper.find(phoneNr);
    }

    public List<Customer> readAll()
    {
        return customerMapper.list();
    }

    public void create(Customer customer) {
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
