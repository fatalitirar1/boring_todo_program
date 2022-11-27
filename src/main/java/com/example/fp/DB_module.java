package com.example.fp;

import java.security.PublicKey;
import java.sql.*;
import java.util.ArrayList;

public class DB_module implements  DB_Use{

    Connection connection;

    {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/toDo",
                    "postgres","root");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList TakeAllTusksDB(ToDo_controller toDo_controller) throws SQLException {



        Statement statement = this.connection.createStatement();
        ResultSet rst = statement.executeQuery("SELECT  * FROM toDo_items");
        ArrayList arrayList = new ArrayList();
        while (rst.next())
        {
            Task task = new Task(toDo_controller).setNewName(rst.getString("task_name"))
                    .setNewCondition(rst.getBoolean("task_condition"))
                    .setNewID(rst.getInt("task_id")).build();

            arrayList.add(task);
        }
        statement.close();

        return arrayList;
    }


    @Override
    public ArrayList TakeAllTusksDB() throws SQLException {
        return null;
    }

    @Override
    public void UploadTask(String name,boolean condition,int id) throws SQLException
    {

        PreparedStatement  pst = this.connection.prepareStatement(
                "UPDATE  toDo_items SET task_name = ?, task_condition = ? WHERE task_id = ?");

        pst.setString(1,name);
        pst.setBoolean(2,condition);
        pst.setInt(3,id);

        pst.executeUpdate();
        pst.close();
    }
    @Override
    public void UploadTask(String name,boolean condition) throws SQLException
    {
        PreparedStatement  pst = this.connection.prepareStatement(
                "INSERT INTO toDo_items (task_name, task_condition) VALUES (?, ? );");

        pst.setString(1,name);
        pst.setBoolean(2,condition);

        pst.executeUpdate();
        pst.close();
    }

    @Override
    public void deleteTask(String name_string, boolean condition_bool, int id) throws SQLException {

        PreparedStatement  pst = this.connection.prepareStatement(
                "DELETE FROM toDo_items WHERE task_id = ?;");

        pst.setInt(1,id);

        pst.executeUpdate();
        pst.close();
    }

    public DB_module()  {

    }
}
