package com.example.mvcapplication.views;

import com.example.mvcapplication.controllers.EmployeeController;
import com.example.mvcapplication.models.Employee;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class EmployeeView extends VBox {
    private final TableView<Employee> tableView;
    private final EmployeeController controller;

    public EmployeeView(EmployeeController controller) {
        this.controller = controller;
        this.tableView = new TableView<>();
        createSearchBar();
        createTable();
        bindTableData();
        this.getChildren().addAll(createSearchBar(), tableView);
    }

    private HBox createSearchBar() {
        HBox searchBox = new HBox(5);

        Label label = new Label("First Name:");
        TextField nameField = new TextField();
        Button searchButton = new Button("Search");

        searchButton.setOnAction(e -> {
            String name = nameField.getText().trim();
            tableView.setItems(controller.getEmployeesByFirstName(name));
        });

        searchBox.getChildren().addAll(label, nameField, searchButton);
        return searchBox;
    }

    private void createTable() {
        tableView.getColumns().clear();

        TableColumn<Employee, String> firstNameCol = new TableColumn<>("First Name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<Employee, String> lastNameCol = new TableColumn<>("Last Name");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<Employee, Double> salaryCol = new TableColumn<>("Salary");
        salaryCol.setCellValueFactory(new PropertyValueFactory<>("salary"));

        TableColumn<Employee, Integer> departmentCol = new TableColumn<>("Department");
        departmentCol.setCellValueFactory(new PropertyValueFactory<>("departmentId"));

        tableView.getColumns().addAll(firstNameCol, lastNameCol, salaryCol, departmentCol);
    }

    private void bindTableData() {
        tableView.setItems(controller.getEmployees());
    }
}
