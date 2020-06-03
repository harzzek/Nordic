package com.example.demo.Model.Customers;

import com.example.demo.Model.ExceptionPackage.CustomerException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest
{
    //Arrange
    //Act
    //Assert

    @Test
    void testCreationOfCustomerWithNumbers()
    {
        //Arrange
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        Customer customer3 = new Customer();

        boolean thrown1 = false;
        boolean thrown2 = false;
        boolean thrown3 = false;

        //Act
        try {
            customer1.setCustomerFname("Hans Christian");
            customer1.setCustomerLname("Leth-Nissen");
        } catch (CustomerException e)
        {
            thrown1 = true;
        }

        try {
            customer2.setCustomerFname("Hans1 Christian");
            customer2.setCustomerLname("Leth-Nissen");
        } catch (CustomerException e)
        {
            thrown2 = true;
        }

        try {
            customer3.setCustomerFname("Hans Christian");
            customer3.setCustomerLname("Leth5-Nissen");
        } catch (CustomerException e)
        {
            thrown3 = true;
        }

        //Assert
        assertFalse(thrown1);
        assertTrue(thrown2);
        assertTrue(thrown3);
    }
}