package com.example.demo.Database;

import java.util.ArrayList;

public abstract class DatabaseManager
{
    public abstract void create();

    public abstract void delete();

    public abstract void update();

    public abstract ArrayList list();

    public abstract Object find(int id);

}
