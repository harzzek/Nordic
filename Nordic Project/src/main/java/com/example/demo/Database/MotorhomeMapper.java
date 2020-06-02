package com.example.demo.Database;

import com.example.demo.Model.Bookings.Booking;
import com.example.demo.Model.Motorhomes.Motorhome;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class MotorhomeMapper
{
    PreparedStatement statement;
    Connection connection;
    DatabaseManager db = new DatabaseManager();

    public void create(Motorhome motorhome)
    {

        try {
            connection = DatabaseManager.getConnection();
            String sql = "INSERT INTO motorhomes Values(DEFAULT,?,?,?,?)";
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1,motorhome.getType());
            statement.setString(2,motorhome.getBrand());
            statement.setString(3,motorhome.getModel());
            statement.setInt(4,motorhome.getSize());
            statement.execute();
            db.closeCon(statement,connection);
        } catch (SQLException e)
        {
            System.out.println(e);
        }

    }

    public ArrayList<Motorhome> avaiableMotorhomes(LocalDate startDate, LocalDate endDate)
    {
        BookingMapper bookingMapper = new BookingMapper();
        ArrayList<Motorhome> motorhomeArray = list();
        ArrayList<Booking> bookingArrayList =  bookingMapper.listOfBookings();
        LocalDate bookingStartDate;
        LocalDate bookingEndDate;
        for (Booking booking:bookingArrayList)
        {

            for (Motorhome motorhome: motorhomeArray)
            {

                if (booking.getIdMotorhome() == motorhome.getIdMotorhome())
                {
                    bookingStartDate = booking.getBookingDate();
                    bookingEndDate = booking.getBookingEndDate();
                    if (!bookingStartDate.isBefore(startDate) && !bookingEndDate.isAfter(endDate))
                    {
                        motorhomeArray.remove(motorhome);
                        break;
                    }
                }
            }
        }

        return  motorhomeArray;
    }

    public void deleteMotorhome(int id) {

        try {
            connection = DatabaseManager.getConnection();
            String sqlDelete = "Delete from motorhomes where idMotorhome = ? ";
            statement = connection.prepareStatement(sqlDelete);
            statement.setInt(1,id);
            statement.execute();
            db.closeCon(statement,connection);
        } catch (SQLException e)
        {
            System.out.println(e);
        }
    }

    public void update() {

    }

    public ArrayList<Motorhome> list() {
        ArrayList<Motorhome> motorhomeList = new ArrayList();
        try {
            connection = DatabaseManager.getConnection();
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


                motorhomeList.add(new Motorhome(idMotorhome,  type, brand, model, size));
            }
            db.closeCon(rs,statement,connection);

        } catch (SQLException e)
        {
            System.out.println(e);
        }

        return motorhomeList;
    }

    public Motorhome find(int id) {
        ResultSet rs;
        Motorhome theMotorhome = null;
        try {
            connection = DatabaseManager.getConnection();
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

                theMotorhome = new Motorhome(idMotorhome,type,brand,model,size);
            }
            db.closeCon(rs,statement,connection);


        } catch (SQLException e)
        {
            System.out.println(e);
        }
        return theMotorhome;
    }
}
