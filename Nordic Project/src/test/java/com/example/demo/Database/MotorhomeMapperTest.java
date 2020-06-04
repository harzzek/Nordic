package com.example.demo.Database;

import com.example.demo.Model.Bookings.Booking;
import com.example.demo.Model.ExceptionPackage.BookingException;
import com.example.demo.Model.Motorhomes.Motorhome;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

//Kodet som gruppe

class MotorhomeMapperTest {

    @Test
    void testAvaiableMotorhomesIntercept() throws BookingException {

        //Arrange
        MotorhomeMapper motorhomeMapper = new MotorhomeMapper();
        Booking booking1 = new Booking();
        boolean motorhomeIsThere = false;

        //Intercept
        booking1.setBookingDate("2020-08-03");
        booking1.setBookingEndDate("2020-08-10");


        //Act
        ArrayList<Motorhome> motorhomeArrayList= motorhomeMapper.avaiableMotorhomes(booking1);

        for (Motorhome motorhome:motorhomeArrayList)
        {
            if(motorhome.getIdMotorhome() == 14)
            {
                motorhomeIsThere = true;
            }
        }

        //Assert
        assertFalse(motorhomeIsThere);

    }

    @Test
    void testAvaiableMotorhomesOverlap() throws BookingException {

        //Arrange
        MotorhomeMapper motorhomeMapper = new MotorhomeMapper();
        boolean motorhomeIsThere = false;
        Booking booking2 = new Booking();

        //Overlap
        booking2.setBookingDate("2020-08-03");
        booking2.setBookingEndDate("2020-08-18");

        //Act
        ArrayList<Motorhome> motorhomeArrayList= motorhomeMapper.avaiableMotorhomes(booking2);

        for (Motorhome motorhome:motorhomeArrayList)
        {
            if(motorhome.getIdMotorhome() == 14)
            {
                motorhomeIsThere = true;
            }
        }

        //Assert
        assertFalse(motorhomeIsThere);

    }

    @Test
    void testAvaiableMotorhomesExtend() throws BookingException {

        //Arrange
        MotorhomeMapper motorhomeMapper = new MotorhomeMapper();
        boolean motorhomeIsThere = false;
        Booking booking3 = new Booking();

        //Extend
        booking3.setBookingDate("2020-08-13");
        booking3.setBookingEndDate("2020-08-18");

        //Act
        ArrayList<Motorhome> motorhomeArrayList= motorhomeMapper.avaiableMotorhomes(booking3);

        for (Motorhome motorhome:motorhomeArrayList)
        {
            if(motorhome.getIdMotorhome() == 14)
            {
                motorhomeIsThere = true;
            }
        }

        //Assert
        assertFalse(motorhomeIsThere);

    }

    @Test
    void testAvaiableMotorhomesInside() throws BookingException {

        //Arrange
        MotorhomeMapper motorhomeMapper = new MotorhomeMapper();
        boolean motorhomeIsThere = false;
        Booking booking4 = new Booking();

        //Inside
        booking4.setBookingDate("2020-08-07");
        booking4.setBookingEndDate("2020-08-14");

        //Act
        ArrayList<Motorhome> motorhomeArrayList= motorhomeMapper.avaiableMotorhomes(booking4);

        for (Motorhome motorhome:motorhomeArrayList)
        {
            if(motorhome.getIdMotorhome() == 14)
            {
                motorhomeIsThere = true;
            }
        }

        //Assert
        assertFalse(motorhomeIsThere);

    }
}