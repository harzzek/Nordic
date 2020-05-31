package com.example.demo.Database;

import com.example.demo.Model.Motorhomes.Motorhome;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class MotorhomeMapper
{
    PreparedStatement statement;
    Connection connection = DatabaseManager.getConnection();

    public void create(Motorhome motorhome)
    {
        try {
            String sql = "INSERT INTO motorhomes Values(DEFAULT,?,?,?,?,?)";
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1,motorhome.getType());
            statement.setString(2,motorhome.getBrand());
            statement.setString(3,motorhome.getModel());
            statement.setInt(4,motorhome.getSize());
            statement.setString(5,motorhome.getStatus());
            statement.execute();
        } catch (Exception e)
        {
            System.out.println(e);
        }

    }

    public ArrayList<Motorhome> availableMotorhomes(LocalDate startDate, LocalDate endDate)
    {
        ArrayList<Motorhome> motorhomeArray = new ArrayList();
        try {
            String sqlQuary1 = "SELECT * FROM motorhomes where exists (SELECT idMotorhome from bookings WHERE (?,?) between bookingDate and bookingEndDate)";
            statement.setDate(1, Date.valueOf(startDate));
            statement.setDate(2, Date.valueOf(endDate));
            statement = connection.prepareStatement(sqlQuary1);
            ResultSet rs = statement.executeQuery();

            while (rs.next())
            {
                int idMotorhome = rs.getInt("idMotorhome");
                String type = rs.getString("type");
                String brand = rs.getString("brand");
                String model = rs.getString("model");
                int size = rs.getInt("size");
                String status = rs.getString("status");


                motorhomeArray.add(new Motorhome(idMotorhome,  type, brand, model, size, status));
            }

        } catch (Exception e)
        {
            System.out.println(e);
        }

        return  motorhomeArray;
    }

    public void deleteMotorhome(int id) {

        try {
            String sqlDelete = "Delete from motorhomes where idMotorhome = ? ";
            statement = connection.prepareStatement(sqlDelete);
            statement.setInt(1,id);
            statement.execute();
        } catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public void update() {

    }

    public ArrayList<Motorhome> list() {
        ArrayList<Motorhome> motorhomeList = new ArrayList();
        try {
            String sqlQuary1 = "SELECT * from motorhomes";
            statement = connection.prepareStatement(sqlQuary1);
            ResultSet rs = statement.executeQuery();

            while (rs.next())
            {
                int idMotorhome = rs.getInt("idMotorhome");
                String type = rs.getString("type");
                String brand = rs.getString("brand");
                String model = rs.getString("model");
                int size = rs.getInt("size");
                String status = rs.getString("status");


                motorhomeList.add(new Motorhome(idMotorhome,  type, brand, model, size, status));
            }

        } catch (Exception e)
        {
            System.out.println(e);
        }

        return motorhomeList;
    }

    public Motorhome find(int id) {
        ResultSet rs;
        Motorhome theMotorhome = null;
        try {
            String sql = "SELECT * from motorhomes where idMotorhome = ?";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1,id);

            rs = statement.executeQuery();
            while (rs.next()) {
                int idMotorhome = rs.getInt("idMotorhome");
                String type = rs.getString("type");
                String brand = rs.getString("brand");
                String model = rs.getString("model");
                int size = rs.getInt("size");
                String status = rs.getString("status");

                theMotorhome = new Motorhome(idMotorhome,type,brand,model,size,status);
            }

        } catch (Exception e)
        {
            System.out.println(e);
        }
        return theMotorhome;
    }
}
