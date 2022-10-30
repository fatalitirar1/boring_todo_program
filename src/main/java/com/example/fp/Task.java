package com.example.fp;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class Task {

    public Label name = new Label();
    public CheckBox condition = new CheckBox();
    public Label getName()
    {
        return name;
    }

    public CheckBox getCondition()
    {
        return condition;
    }

    public Task(String name)
    {
        this.name.setText(name);
    }
}
