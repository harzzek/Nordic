package com.example.demo.Model.Bookings;

import com.example.demo.Database.BookingMapper;

import java.util.List;

//Kodet af Jonas

public class BookingHandler
{
    BookingMapper bookingMapper;

    public Booking read(int phoneNr)
    {
        bookingMapper = new BookingMapper();
        return bookingMapper.findBooking(phoneNr);
    }

    public List<Booking> readAll()
    {
        bookingMapper = new BookingMapper();
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
        bookingMapper = new BookingMapper();
       bookingMapper.createBooking(booking);
    }


}
