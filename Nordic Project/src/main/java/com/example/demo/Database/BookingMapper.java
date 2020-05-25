package com.example.demo.Database;

import com.example.demo.Model.Booking;
import com.example.demo.Model.Bookings;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import static com.example.demo.Database.DatabaseManager.getConnection;

public class BookingMapper
{
    Bookings bookings = new Bookings();
    DatabaseManager databaseConnection;

    public void createBooking(Motorhome motorhome, Customer customer)
    {

    }

    public void deleteBooking(int phoneNr)
    {

    }

    public void updateBooking(Booking booking)
    {

    }

    public ArrayList<Booking> listOfBookings()
    {

    }

    public Booking findBooking(int phoneNr)
    {
        ResultSet rs;
        Booking theBooking = bookings.sendSheet;
        try {
            PreparedStatement statement = getConnection().prepareStatement("SELECT * from bookings where customerPhone = ?");
            rs = statement.executeQuery();
            while (rs.next()) {
                int idBooking = rs.getInt("idBooking");
                Date enrollmentDate = rs.getDate("bookingDate");
                LocalDate date = enrollmentDate.toLocalDate();
                String pickup = rs.getString("pickup");
                String dropoff = rs.getString("dropoff");
                int customerPhone = phoneNr;
                int idMotorhome = rs.getInt("idMotorhome");

                theBooking = new Booking(idBooking, date, pickup, dropoff, customerPhone, idMotorhome);
            }

        } catch (Exception e)
        {
            System.out.println(e);
        }
        return theBooking;
    }
}
