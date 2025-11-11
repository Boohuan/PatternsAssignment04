package com.example.mvcapplication.views;

import com.example.mvcapplication.controllers.DepartmentController;
import com.example.mvcapplication.models.Department;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import java.io.IOException;

public class DepartmentView {

    @FXML
    private Button employeeTable;
    @FXML
    private Button projectsTable;
    @FXML
    private Button activeProjects;
    @FXML
    private TableView<Department> table;
    @FXML
    private TableColumn<Department, String> id;
    @FXML
    private TableColumn<Department, String> departmentName;
    private final DepartmentController controller;

    public DepartmentView(DepartmentController controller) {
        this.controller = controller;
    }

    @FXML
    protected void  showProjectsWindowButton(Stage stage) throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("Project Window.fxml"));
        stage.setTitle("Projects");
        Stage load = fxml.load();
        stage.show();
    }

    @FXML
    protected void showEmployeeWindowButton(Stage stage) throws IOException{
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("Project Window.fxml")); //discuss how this will work
        stage.setTitle("Employees");
        Stage load = fxml.load();
        stage.show();
    }

    @FXML
    protected void showActiveProjectsWindowButton(Stage stage) throws IOException{
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("Employee-projects window.fxml"));
        stage.setTitle("Projects");
        Stage load = fxml.load();
        stage.show();
    }

    @FXML
    protected void tableOnLoad(){
        table.setItems(controller.getDepartments());
    }
}
