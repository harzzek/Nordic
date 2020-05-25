package com.example.demo.Model;

public class Bookings
{
   /* public Booking read(phoneNr){
        return Booking;
    }*/

    public Booking readAll(){
        return Booking;
    }
    public boolean update(Booking booking){
        return false;
    }
    public boolean delete(int phone){
        return false;
    }

    @Override
    public String toString()
    {
        return null;
    }
}
