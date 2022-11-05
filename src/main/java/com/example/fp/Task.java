package com.example.fp;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.util.stream.Stream;


public class Task implements Task_Make {

    public Label name = new Label();
    public CheckBox state = new CheckBox();
    public Label getName()
    {
        return name;
    }

    public CheckBox getCondition()
    {
        return state;
    }

    public Task(String name)
    {
        this.name.setText(name);
    }

    @Override
    public void setNewName(String newName) {
        this.name.setText(newName);
    }

    @Override
    public void setNewCondition(Boolean state) {
        this.state.setSelected(state);

    }
}
