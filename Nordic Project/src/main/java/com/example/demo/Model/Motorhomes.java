package com.example.demo.Model;

import com.example.demo.Database.MotorhomeMapper;

import java.util.ArrayList;

public class Motorhomes
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

    public boolean delete(int id)
    {
        return false;
    }

    public String toSting()
    {
        return null;
    }

    public void create(String type, String brand, String model, int size, String status){
        Motorhome motorhome = new Motorhome(type, brand, model, size, status);
        motorhomeMapper.create(motorhome);
    }
}
