package com.example.demo.Model.Motorhomes;

import com.example.demo.Database.MotorhomeMapper;
import com.example.demo.Model.Bookings.Booking;

import java.util.ArrayList;

public class MotorhomeHandler
{
    MotorhomeMapper motorhomeMapper = new MotorhomeMapper();

    public Motorhome read(int id)
    {
        return motorhomeMapper.find(id);
    }

    public ArrayList<Motorhome> readAll()
    {
        return motorhomeMapper.list();
    }

    public ArrayList<Motorhome> findAvailable(Booking booking)
    {
        return motorhomeMapper.avaiableMotorhomes(booking);
    }

    public boolean delete(int id)
    {
        Motorhome mo = motorhomeMapper.find(id);
        if (mo.getIdMotorhome() == read(id).getIdMotorhome()){
            motorhomeMapper.deleteMotorhome(id);
            return true;
        }
        return false;
    }

    public String toSting()
    {
        return null;
    }

    public void create(Motorhome motorhome){
        motorhomeMapper.create(motorhome);
    }
}
