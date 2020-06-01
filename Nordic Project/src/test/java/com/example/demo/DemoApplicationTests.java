package com.example.demo;

import com.example.demo.Model.Customers.Customer;
import com.example.demo.Model.Customers.CustomerHandler;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests
{

    @Test
    void createCustomer()
    {
        Customer customer1 = new Customer(44664495, "Benny", "Hansen", "BigBoi@gmail.com");
        Customer customer2 = new Customer(13335544, "Carl", "Carson", "Crizz@hotmail.com");
        Customer customer3 = new Customer(7788, "Tenis1", "Boel", "Kelp@private.dk");

        CustomerHandler customerHandler = new CustomerHandler();
        customerHandler.create(customer1);
        customerHandler.create(customer2);
        customerHandler.create(customer3);


    }

}
