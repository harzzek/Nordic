package com.example.demo.Model;

public class Customer {

    int idCustomer;
    int customerPhone;
    String customerFname;
    String customerLname;
    String customerEmail;

    public Customer(int idCustomer, String customerFname, String customerLname, int customerPhone, String customerEmail)
    {
        this.idCustomer = idCustomer;
        this.customerPhone = customerPhone;
        this.customerFname = customerFname;
        this.customerLname = customerLname;
        this.customerEmail = customerEmail;
    }
    public int getIdCustomer()
    {
        return idCustomer;
    }
    public void setIdCustomer(int idCustomer)
    {
        this.idCustomer = idCustomer;
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
