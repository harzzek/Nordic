package com.example.demo.Model;

import com.example.demo.Database.BookingMapper;

import java.time.LocalDate;

public class Bookings
{
    BookingMapper bookingMapper = new BookingMapper();

    public Booking read(int phoneNr)
    {
        return bookingMapper.findBooking(phoneNr);
    }

    public Booking readAll()
    {
        return null;
    }
    public boolean update( Booking booking)
    {
        return false;
    }
    public boolean delete(int phone)
    {
        return false;
    }



    public String toString()
    {
        return null;
    }

}
