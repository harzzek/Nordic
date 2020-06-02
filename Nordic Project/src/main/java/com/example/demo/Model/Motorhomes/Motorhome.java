package com.example.demo.Model.Motorhomes;

import com.example.demo.Model.ExceptionPackage.MotorhomeException;

public class Motorhome
{

    int idMotorhome;
    String type;
    String brand;
    String model;
    int size;

    public Motorhome(String type, String brand, String model, int size){
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.size = size;
    }

    public Motorhome(int idMotorhome, String type, String brand, String model, int size){
        this.idMotorhome = idMotorhome;
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.size = size;
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

    public void setIdMotorhome(int idMotorhome) {
        this.idMotorhome = idMotorhome;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSize(int size) throws MotorhomeException {

        if(size > 6 || size < 2) {
            throw new MotorhomeException("Vehicle can't be larger than 6 or smaller than 2: " + size);
        } else this.size = size;
    }


}
