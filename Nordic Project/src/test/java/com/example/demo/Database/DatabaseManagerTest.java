package com.example.demo.Database;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

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
    void closeStatementTest() throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * from bookings");
        DatabaseManager.closeCon(statement, connection);
        assertTrue(statement.isClosed());
    }
}