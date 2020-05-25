package com.example.demo.Model;

public class Customer {

    int customerPhone;
    String customerFname;
    String customerLname;
    String customerEmail;

    public Customer(int customerPhone, String customerFname, String customerLname, String customerEmail)
    {
        this.customerPhone = customerPhone;
        this.customerFname = customerFname;
        this.customerLname = customerLname;
        this.customerEmail = customerEmail;
    }

    public String getCustomerFname()
    {
        return customerFname;
    }

    public String getCustomerLname()
    {
        return customerLname;
    }

    public int getCustomerPhone()
    {
        return customerPhone;
    }

    public String getCustomerEmail()
    {
        return customerEmail;
    }
}
