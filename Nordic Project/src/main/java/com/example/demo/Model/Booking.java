package com.example.demo.Model;

import java.time.LocalDate;

public class Booking
{
    int idBooking;
    LocalDate bookingDate;
    String pickup;
    String dropoff;
    Customer customer;
    Motorhome motorhome;

    public void Booking(LocalDate bookingDate, String pickup, String dropoff, Customer customer, Motorhome motorhome)
    {
        this.bookingDate = bookingDate;
        this.pickup = pickup;
        this.dropoff = dropoff;
        this.customer = customer;
        this.motorhome = motorhome;
    }

    public void Booking(LocalDate bookingDate, Customer customer, Motorhome motorhome)
    {
        this.bookingDate = bookingDate;
        this.customer = customer;
        this.motorhome = motorhome;
    }
}
