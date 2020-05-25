package com.example.demo.Model;

import com.example.demo.Database.BookingMapper;

public class Bookings
{
    BookingMapper bookingMapper = new BookingMapper();

    public Booking read(int phoneNr)
    {
        Booking newBooking = new Booking();
        return bookingMapper.findBooking(phoneNr);
    }

        public Booking readAll()
    {
        return Booking;
    }
        public boolean update( Booking booking){
        return false;
    }
        public boolean delete(int phone){
        return false;
    }



    public String toString()
    {
        return null;
    }

}
