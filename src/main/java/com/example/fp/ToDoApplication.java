package com.example.fp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class ToDoApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(ToDoApplication.class.getResource("ToDo-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Yep its.. just boring todo program. But at least she existing ");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}