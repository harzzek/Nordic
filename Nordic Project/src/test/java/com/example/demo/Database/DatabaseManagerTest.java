package com.example.demo.Database;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseManagerTest {

    Connection connection;
    @BeforeEach
    void setUp() {
        connection = DatabaseManager.getConnection();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void getConnection() {
    }
}