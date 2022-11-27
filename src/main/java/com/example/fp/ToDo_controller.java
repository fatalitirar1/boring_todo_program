package com.example.fp;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
public class ToDo_controller {

      ObservableList<Task> tasks = FXCollections.observableArrayList();


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea Text_WhatToDo;

    @FXML
    private Button add;

    @FXML
    private TableColumn<Task, CheckBox> todoCheck;

    @FXML
    private TableColumn<Task, Label> todoName;

    @FXML
    private TableView<Task> todotable;


    @FXML
    public  void AddNewTask(ActionEvent event) throws SQLException {
        todoName.setCellValueFactory(new PropertyValueFactory<Task, Label>("name"));
        todoCheck.setCellValueFactory(new PropertyValueFactory<Task, CheckBox>("condition"));

        String Line = Text_WhatToDo.getText();
        if (!Line.isEmpty()) {


            Task task_ = new Task(this).setNewName(Line).setNewCondition(false).build();

            DB_module db_module = new DB_module();
            tasks.add(task_);
            db_module.UploadTask(task_.getName_String(),task_.getCondition_bool());

            todotable.setItems(tasks);
            Text_WhatToDo.setText("");
        }
    }

    @FXML
    void initialize() {
        db_initialize();
    }
    void db_initialize()
    {
        todoName.setCellValueFactory(new PropertyValueFactory<Task, Label>("name"));
        todoCheck.setCellValueFactory(new PropertyValueFactory<Task, CheckBox>("condition"));
        DB_module db_module = new DB_module();
        ArrayList arrayList = new ArrayList();
        try {
            arrayList = db_module.TakeAllTusksDB(this);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            tasks.add((Task) iterator.next());
        }
        todotable.setItems(tasks);
    }
    @FXML
    void TableOnButtonClick(KeyEvent event) {
        if (event.getCode().name().equals("DELETE"))
        {
            DB_module db_module = new DB_module();
            Task task = todotable.getSelectionModel().getSelectedItem();
            tasks.remove(todotable.getSelectionModel().getSelectedItem());
            todotable.setItems(tasks);
            try {
                db_module.deleteTask(task.getName_String(), task.getCondition_bool(), task.id);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
    @FXML
    void EditCondition(ActionEvent event) throws SQLException {

        DB_module db_module = new DB_module();
        Task task = todotable.getSelectionModel().getSelectedItem();
        db_module.UploadTask(task.getName_String(), task.getCondition_bool(), task.id);

    }

}
