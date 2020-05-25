package com.example.demo.Model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Booking
{
    int idBooking;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate bookingDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate bookingEndDate;
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

    public Booking(int idBooking, LocalDate bookingDate, LocalDate bookingEndDate, String pickup, String dropoff, int idCustomer, int idMotorhome)
    {
        this.idBooking = idBooking;
        this.bookingDate = bookingDate;
        this.bookingEndDate = bookingEndDate;
        this.pickup = pickup;
        this.dropoff = dropoff;
        this.idCustomer = idCustomer;
        this.idMotorhome = idMotorhome;
    }
}
