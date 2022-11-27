package com.example.fp;

public interface Task_Make {
    Task_Make setNewName(String newName);
    Task_Make setNewCondition(Boolean state);
    Task_Make setNewID(int id);
    Task_Make build();
}


