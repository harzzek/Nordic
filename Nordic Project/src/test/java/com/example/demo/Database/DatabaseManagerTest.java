package com.example.demo.Database;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

//Kodet som gruppe

class DatabaseManagerTest {

    Connection connection;
    @BeforeEach
    void setUp() {
        connection = DatabaseManager.getConnection();
    }

    @AfterEach
    void tearDown() throws SQLException {
        DatabaseManager.closeCon(connection);
    }

    @Test
    void closeStatementAndConnectionTest() throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * from bookings");
        DatabaseManager.closeCon(statement, connection);
        assertTrue(connection.isClosed());
        assertTrue(statement.isClosed());
    }
    @Test
    void openConnectionAndStatementTest() throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM customers");
        assertFalse(connection.isClosed());
        assertFalse(statement.isClosed());
    }
}