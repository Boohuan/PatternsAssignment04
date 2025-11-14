package com.example.mvcapplication;

import com.example.mvcapplication.controllers.EmployeeController;
import com.example.mvcapplication.views.EmployeeView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        EmployeeView view = new EmployeeView(new EmployeeController());
        Scene scene = new Scene(view, 600, 400);
        stage.setTitle("Employees");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}