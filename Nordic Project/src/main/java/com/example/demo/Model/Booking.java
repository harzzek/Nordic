package com.example.demo.Model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Booking
{
    private int idBooking;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate bookingDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate bookingEndDate;
    private String pickup;
    private String dropoff;
    private int idCustomer;
    private int idMotorhome;

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
    public int getIdBooking() {
        return idBooking;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public LocalDate getBookingEndDate() {
        return bookingEndDate;
    }

    public String getPickup() {
        return pickup;
    }

    public String getDropoff() {
        return dropoff;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public int getIdMotorhome() {
        return idMotorhome;
    }

}
