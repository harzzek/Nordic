package com.example.demo.Model.Bookings;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Booking
{
    private int idBooking;

    @DateTimeFormat(pattern = "yyyy-mm-dd") //todo Tjek om formattet er vigtig, eller Default
    private LocalDate bookingDate;
    @DateTimeFormat(pattern = "yyyy-mm-dd") //todo
    private LocalDate bookingEndDate;
    private String pickup;
    private String dropoff;
    private int customerPhone;
    private int idMotorhome;

    public Booking(LocalDate bookingDate, LocalDate bookingEndDate, String pickup, String dropoff, int customerPhone, int idMotorhome)
    {
        this.bookingDate = bookingDate;
        this.bookingEndDate = bookingEndDate;
        this.pickup = pickup;
        this.dropoff = dropoff;
        this.customerPhone = customerPhone;
        this.idMotorhome = idMotorhome;
    }

    public Booking(int idBooking, LocalDate bookingDate, LocalDate bookingEndDate, String pickup, String dropoff, int customerPhone, int idMotorhome)
    {
        this.idBooking = idBooking;
        this.bookingDate = bookingDate;
        this.bookingEndDate = bookingEndDate;
        this.pickup = pickup;
        this.dropoff = dropoff;
        this.customerPhone = customerPhone;
        this.idMotorhome = idMotorhome;
    }
    public Booking(){

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

    public int getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(int customerPhone) {
        this.customerPhone = customerPhone;
    }

    public int getIdMotorhome() {
        return idMotorhome;
    }
    public void setIdBooking(int idBooking) {
        this.idBooking = idBooking;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = LocalDate.parse(bookingDate);
    }

    public void setBookingEndDate(String bookingEndDate) {
        this.bookingEndDate = LocalDate.parse(bookingEndDate);
    }

    public void setPickup(String pickup) {
        this.pickup = pickup;
    }

    public void setDropoff(String dropoff) {
        this.dropoff = dropoff;
    }

    public void setIdMotorhome(int idMotorhome) {
        this.idMotorhome = idMotorhome;
    }

}
