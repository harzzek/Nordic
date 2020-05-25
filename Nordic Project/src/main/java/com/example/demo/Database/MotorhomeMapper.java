package com.example.demo.Database;

import com.example.demo.Model.Motorhome;
import com.example.demo.Model.Motorhomes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MotorhomeMapper extends DatabaseManager
{
    Motorhomes motorhomes = new Motorhomes();
    PreparedStatement statement;

    public void create(Motorhome motorhome)
    {
        try {
            String sql = "INSERT INTO motorhomes Values(DEFAULT,?,?,?,?,?)";
            statement = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1,motorhome.getType());
            statement.setString(2,motorhome.getBrand());
            statement.setString(3,motorhome.getModel());
            statement.setInt(4,motorhome.getSize());
            statement.setInt(5,motorhome.isStatus());
            statement.executeQuery();
        } catch (Exception e)
        {
            System.out.println(e);
        }

    }

    public void delete() {

    }

    public void update() {

    }

    public ArrayList<Motorhome> list() {
        ArrayList<Motorhome> motorhomeList = new ArrayList();
        try {
            String sqlQuary1 = "SELECT * from motorhomes";
            statement = getConnection().prepareStatement(sqlQuary1);
            ResultSet rs = statement.executeQuery();

            while (rs.next())
            {
                int idMotorhome = rs.getInt("idMotorhome");
                String type = rs.getString("type");
                String brand = rs.getString("brand");
                String model = rs.getString("model");
                int size = rs.getInt("size");
                int status = rs.getInt("status");
                boolean workStatus = false;
                if (status == 1)
                {
                    workStatus = true;
                }

                motorhomeList.add(new Motorhome(idMotorhome,  type, brand, model, size, workStatus));
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
            PreparedStatement statement = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1,id);

            rs = statement.executeQuery();
            while (rs.next()) {
                int idMotorhome = rs.getInt("idMotorhome");
                String type = rs.getString("type");
                String brand = rs.getString("brand");
                String model = rs.getString("model");
                int size = rs.getInt("size");
                int status = rs.getInt("status");
                boolean workStatus = false;
                if (status == 1)
                {
                    workStatus = true;
                }

                theMotorhome = new Motorhome(idMotorhome,type,brand,model,size,workStatus);
            }

        } catch (Exception e)
        {
            System.out.println(e);
        }
        return theMotorhome;
    }
}
