package com.example.demo.Model.Customers;

import com.example.demo.Model.Bookings.Booking;
import com.example.demo.Model.ExceptionPackage.CustomerException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    private Customer customer1;
    private Customer customer2;
    private Customer customer3;

    boolean thrown1 = true;
    boolean thrown2 = true;
    boolean thrown3 = true;

    @BeforeEach
    void setUp() {
        //Customers arrange
        customer1 = new Customer();
        customer2 = new Customer();
        customer3 = new Customer();
    }

    @Test
    void customerWithNumberInName() throws CustomerException {

        // Act
        try {
            customer1.setCustomerFname("Hans Christian");
            customer1.setCustomerLname("Leth-Nissen");
        } catch (CustomerException e)
        {
            thrown1 = false;
        }

        try {
            customer2.setCustomerFname("Hans1 Christian");
            customer2.setCustomerLname("Leth-Nissen");
        } catch (CustomerException e)
        {
            thrown2 = false;
        }

        try {
            customer3.setCustomerFname("Hans Christian");
            customer3.setCustomerLname("Leth-Nissen6");
        } catch (CustomerException e)
        {
            thrown3 = false;
        }

        //assert
        assertTrue(thrown1 == true);
        assertFalse(thrown2 == true);
        assertFalse(thrown3 == true);

    }
}