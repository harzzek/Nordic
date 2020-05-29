package com.example.demo.Model.Customers;

public class Customer {

    private int customerPhone;
    private String customerFname;
    private String customerLname;
    private String customerEmail;

    public Customer(int customerPhone, String customerFname, String customerLname, String customerEmail)
    {
        this.customerPhone = customerPhone;
        this.customerFname = customerFname;
        this.customerLname = customerLname;
        this.customerEmail = customerEmail;
    }

    public Customer()
    {

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

    public void setCustomerPhone(int customerPhone) {
        this.customerPhone = customerPhone;
    }


    public String getCustomerEmail()
    {
        return customerEmail;
    }
}
