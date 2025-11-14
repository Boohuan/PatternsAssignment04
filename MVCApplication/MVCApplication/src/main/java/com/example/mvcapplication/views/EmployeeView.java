package com.example.mvcapplication.views;

import com.example.mvcapplication.controllers.DepartmentController;
import com.example.mvcapplication.controllers.EmployeeController;
import com.example.mvcapplication.controllers.EmployeeProjectController;
import com.example.mvcapplication.controllers.ProjectController;
import com.example.mvcapplication.models.Employee;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

import java.util.List;

public class EmployeeView extends AbstractView<Employee, EmployeeController> {

    public EmployeeView(EmployeeController controller) {
        super(controller);
        createTable(List.of("ID", "First Name", "Last Name", "Salary", "Department ID"), List.of("id", "firstName", "lastName", "salary", "departmentId"));
        tableView.setItems(controller.getEmployees());
        //go to department table
        Button department = navigation("Department Table", "Departments", () -> new DepartmentView(new DepartmentController()));
        //go to projects table
        Button projects = navigation("Project Table", "Projects", () -> new ProjectsView(new ProjectController()));
        //go to employee projects table
        Button activeProj = navigation("Active Projects Table", "Employee Projects", () -> new EmployeeProjectView(new EmployeeProjectController()));
        HBox navSection = navButtons(department, projects, activeProj); //creates a sort of div like structure for the buttons
        this.getChildren().addAll(createSearchBar(), tableView, navSection);
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

    private HBox createSearchBar() {
        HBox searchBox = new HBox(5); //search box

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

}
