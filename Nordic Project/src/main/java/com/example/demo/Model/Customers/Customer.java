package com.example.demo.Model.Customers;

import com.example.demo.Model.ExceptionPackage.CustomerException;

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

    public void setCustomerFname(String customerFname) throws CustomerException{
        //        . symbol matches any character except newline.                                            Any character (may or may not match line terminators)
        //        * repeats the character behind it 0 or more times.                                        X, zero or more times
        //        \d matches any digit. The extra \ in \\d is used to escape the backslash from the string. A digit: [0-9]
        if(customerFname.matches(".*\\d.*"))
        {
            throw new CustomerException("Name cannot include numbers: " + customerFname);
        } else
        this.customerFname = customerFname;
    }

    public void setCustomerLname(String customerLname) throws CustomerException{
        if(customerLname.matches(".*\\d.*"))
        {
            throw new CustomerException("Name cannot include numbers: " + customerFname);
        } else
        this.customerLname = customerLname;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
}
