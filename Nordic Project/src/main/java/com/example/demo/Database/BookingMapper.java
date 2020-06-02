package com.example.demo.Database;

import com.example.demo.Model.Bookings.Booking;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class BookingMapper
{
    PreparedStatement statement;
    Connection connection;
    DatabaseManager db = new DatabaseManager();


    public void createBooking(Booking booking)
    {
        try {
            connection = DatabaseManager.getConnection();
            String sql = "INSERT INTO bookings(bookingDate, bookingEndDate, pickup, dropoff, customerPhone, idMotorhome) Values(?,?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            LocalDate startDate = booking.getBookingDate();
            startDate.plusDays(1);
            statement.setDate(1, Date.valueOf(startDate));
            LocalDate endDate = booking.getBookingEndDate();
            endDate.plusDays(1);
            statement.setDate(2, Date.valueOf(endDate));
            statement.setString(3,booking.getPickup());
            statement.setString(4,booking.getDropoff());
            statement.setInt(5,booking.getCustomerPhone());
            statement.setInt(6,booking.getIdMotorhome());
            statement.execute();
            db.closeCon(statement,connection);
        } catch (Exception e)
        {
            e.printStackTrace();
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
        connection = DatabaseManager.getConnection();
        try {
            String sqlQuary1 = "SELECT * from bookings";
            statement = connection.prepareStatement(sqlQuary1);
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
            db.closeCon(rs, statement,connection);

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
        connection = DatabaseManager.getConnection();
        try {
            String sql = "SELECT * from bookings where customerPhone = ?";
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
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
            db.closeCon(rs, statement,connection);

        } catch (Exception e)
        {
            System.out.println(e);
        }
        return theBooking;
    }
}
