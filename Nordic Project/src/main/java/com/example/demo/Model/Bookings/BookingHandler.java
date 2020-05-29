package com.example.demo.Model.Bookings;

import com.example.demo.Database.BookingMapper;

import java.util.List;

public class BookingHandler
{
    BookingMapper bookingMapper = new BookingMapper();

    public Booking read(int phoneNr)
    {
        return bookingMapper.findBooking(phoneNr);
    }

    public List<Booking> readAll()
    {
        return bookingMapper.listOfBookings();
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

    public void create(Booking booking) {
       bookingMapper.createBooking(booking);
    }
}