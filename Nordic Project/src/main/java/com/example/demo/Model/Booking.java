package com.example.demo.Model;

import java.time.LocalDate;

public class Booking
{
    int idBooking;
    LocalDate bookingDate;
    String pickup;
    String dropoff;
    int idCustomer;
    int idMotorhome;

    public Booking(LocalDate bookingDate, String pickup, String dropoff, int idCustomer, int idMotorhome)
    {
        this.bookingDate = bookingDate;
        this.pickup = pickup;
        this.dropoff = dropoff;
        this.idCustomer = idCustomer;
        this.idMotorhome = idMotorhome;
    }

    public Booking(int idBooking, LocalDate bookingDate, String pickup, String dropoff, int idCustomer, int idMotorhome)
    {
        this.idBooking = idBooking;
        this.bookingDate = bookingDate;
        this.pickup = pickup;
        this.dropoff = dropoff;
        this.idCustomer = idCustomer;
        this.idMotorhome = idMotorhome;
    }
}
