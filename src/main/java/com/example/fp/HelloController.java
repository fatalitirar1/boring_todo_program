package com.example.fp;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloController  {

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
    public  void AddNewTask(ActionEvent event) {

        String Line = Text_WhatToDo.getText();
        if (!Line.isEmpty()) {
            todoName.setCellValueFactory(new PropertyValueFactory<Task, Label>("name"));
            todoCheck.setCellValueFactory(new PropertyValueFactory<Task, CheckBox>("condition"));

            Task task_ = new Task(Text_WhatToDo.getText());
            tasks.add(task_);

            todotable.setItems(tasks);
            Text_WhatToDo.setText("");
        }
    }

    @FXML
    void initialize() {


    }

}
