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

    public boolean update()
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
