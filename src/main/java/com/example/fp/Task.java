package com.example.fp;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

import java.sql.SQLException;



public class Task implements Task_Make {

    private Label name;
    private CheckBox condition;

    private ToDo_controller linkWhereButtonLive;
    protected int id;
    public Label getName()
    {
        return this.name;
    }
    public String getName_String()
    {
        return this.name.getText();
    }
    public CheckBox getCondition()
    {
        return  this.condition;
    }
    public boolean getCondition_bool()
    {
        return this.condition.isSelected();
    }


    public Task(ToDo_controller toDo_controller)
    {
        this.name = new Label();
        this.condition = new CheckBox();
        this.linkWhereButtonLive = toDo_controller;
        Set_EventCheckBox();
    }
    @Override
    public Task setNewName(String newName) {
        this.name.setText(newName);
        return this;
    }


    @Override
    public Task setNewCondition(Boolean state) {
        this.condition.setSelected(state);
        return this;
    }
    public void Set_EventCheckBox()  {
        this.condition.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                try {
                    linkWhereButtonLive.EditCondition(event);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }



    @Override
    public Task setNewID(int id) {
        this.id = id;
        return this;
    }

    @Override
    public Task build() {
        return this;
    }


}


