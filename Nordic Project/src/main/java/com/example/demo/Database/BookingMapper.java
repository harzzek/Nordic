package com.example.demo.Database;

import com.example.demo.Model.Booking;
import com.example.demo.Model.Customer;
import com.example.demo.Model.Motorhome;
//import jdk.vm.ci.meta.Local;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class BookingMapper extends DatabaseManager
{
    PreparedStatement statement;


    public void createBooking(Booking booking)
    {
        try {
            String sql = "INSERT INTO bookings Values(?,?,?,?,?,?)";
            statement = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            LocalDate startDate = booking.getBookingDate();
            startDate.plusDays(1);
            statement.setDate(1,Date.valueOf(startDate));
            LocalDate endDate = booking.getBookingEndDate();
            endDate.plusDays(1);
            statement.setDate(2,Date.valueOf(endDate));
            statement.setString(3,booking.getPickup());
            statement.setString(4,booking.getDropoff());
            statement.setInt(5,booking.getcustomerPhone());
            statement.setInt(6,booking.getIdMotorhome());
            statement.execute();
        } catch (Exception e)
        {
            System.out.println(e);
        }


    }

    public void deleteBooking(int phoneNr)
    {

    }

    public void updateBooking(Booking booking)
    {

    }

    public ArrayList<Booking> listOfBookings()
    {
        ArrayList<Booking> bookingList = new ArrayList();
        try {
            String sqlQuary1 = "SELECT * from bookings";
            statement = getConnection().prepareStatement(sqlQuary1);
            ResultSet rs = statement.executeQuery();

            while (rs.next())
            {
                int idBooking = rs.getInt("idBooking");
                Date startDate = rs.getDate("bookingDate");
                LocalDate realStartDate = startDate.toLocalDate();
                Date endDate = rs.getDate("bookingEndDate");
                LocalDate realEndDate = endDate.toLocalDate();
                String pickup = rs.getString("pickup");
                String dropoff = rs.getString("dropoff");
                int customerPhone = rs.getInt("customerPhone");
                int idMotorhome = rs.getInt("idMotorhome");

                bookingList.add(new Booking(idBooking,realStartDate,realEndDate,pickup,dropoff,customerPhone,idMotorhome));
            }

        } catch (Exception e)
        {
            System.out.println(e);
        }

        return bookingList;

    }

    public Booking findBooking(int phoneNr)
    {
        ResultSet rs;
        Booking theBooking = null;
        try {
            String sql = "SELECT * from bookings where customerPhone = ?";
            statement = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1,phoneNr);

            rs = statement.executeQuery();
            while (rs.next()) {
                int idBooking = rs.getInt("idBooking");
                Date startDate = rs.getDate("bookingDate");
                LocalDate realStartDate = startDate.toLocalDate();
                Date endDate = rs.getDate("bookingEndDate");
                LocalDate realEndDate = endDate.toLocalDate();
                String pickup = rs.getString("pickup");
                String dropoff = rs.getString("dropoff");
                int customerPhone = rs.getInt("customerPhone");
                int idMotorhome = rs.getInt("idMotorhome");

                theBooking = new Booking(idBooking,realStartDate,realEndDate,pickup,dropoff,customerPhone,idMotorhome);
            }

        } catch (Exception e)
        {
            System.out.println(e);
        }
        return theBooking;
    }
}
