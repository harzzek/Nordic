package com.example.demo.Model;

public class Motorhome
{
    int idMotorhome;
    String type;
    String brand;
    String model;
    int size;
    String status;

    public Motorhome(String type, String brand, String model, int size, String status){
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.size = size;
        this.status = status;
    }

    public Motorhome(int idMotorhome, String type, String brand, String model, int size, String status){
        this.idMotorhome = idMotorhome;
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.size = size;
        this.status = status;
    }

    public Motorhome(){

    }

    public int getIdMotorhome()
    {
        return idMotorhome;
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

    public String getStatus()
    {
        return status;
    }
}
