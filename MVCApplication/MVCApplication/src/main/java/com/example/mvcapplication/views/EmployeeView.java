package com.example.mvcapplication.views;

import com.example.mvcapplication.controllers.DepartmentController;
import com.example.mvcapplication.controllers.EmployeeController;
import com.example.mvcapplication.controllers.EmployeeProjectController;
import com.example.mvcapplication.controllers.ProjectController;
import com.example.mvcapplication.models.Employee;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.List;

public class EmployeeView extends AbstractView<Employee, EmployeeController> {

    public EmployeeView(EmployeeController controller) {
        super(new EmployeeController());

        createTable(List.of("First Name", "Last Name", "Salary"), List.of("firstName", "lastName", "salary"));

        //go to department table
        VBox departmentWindow = new DepartmentView(new DepartmentController());
        Button department = navigation("Department Table", "Departments", departmentWindow);

        //go to projects table
        VBox projectsWindow = new ProjectsView(new ProjectController());
        Button projects = navigation("Project Table", "Projects", projectsWindow);

        //go to employee projects table
        VBox activeProjWindow = new EmployeeProjectView(new EmployeeProjectController());
        Button activeProj = navigation("Active Projects Table", "Employee Projects", activeProjWindow);
        createSearchBar();
        this.getChildren().addAll(createSearchBar(), tableView);
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

    /*private void createTable() {
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
    }*/
}
