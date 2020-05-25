package com.example.demo.Model;

public class Motorhome
{
    int idMotorhome;
    String type;
    String brand;
    String model;
    int size;
    boolean status;

    public Motorhome(int idMotorhome, String type, String brand, String model, int size, boolean status){
        this.idMotorhome = idMotorhome;
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.size = size;
        this.status = status;
    }

    public int getIdMotorhome()
    {
        return idMotorhome;
    }

    public void setIdMotorhome(int idMotorhome)
    {
        this.idMotorhome = idMotorhome;
    }

    public String getType()
    {
        return type;
    }

    public String getBrand()
    {
        return brand;
    }

    public String getModel()
    {
        return model;
    }

    public int getSize()
    {
        return size;
    }

    public int isStatus()
    {
        if(status == true)
        {
            return 1;
        } else
        return 0;
    }
}
