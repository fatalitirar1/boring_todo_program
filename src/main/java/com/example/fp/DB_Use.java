package com.example.fp;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DB_Use {
    ArrayList TakeAllTusksDB () throws SQLException;
    void UploadTask(String name,boolean condition,int id) throws SQLException;
    void UploadTask(String name,boolean condition) throws SQLException;

    void deleteTask(String name_string, boolean condition_bool, int id) throws SQLException;
}
