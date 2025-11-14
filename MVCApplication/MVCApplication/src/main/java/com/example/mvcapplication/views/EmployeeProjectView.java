package com.example.mvcapplication.views;

import com.example.mvcapplication.controllers.DepartmentController;
import com.example.mvcapplication.controllers.EmployeeController;
import com.example.mvcapplication.controllers.EmployeeProjectController;
import com.example.mvcapplication.controllers.ProjectController;
import com.example.mvcapplication.models.EmployeeProjects;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.util.List;

public class EmployeeProjectView extends AbstractView<EmployeeProjects, EmployeeProjectController> {

    public EmployeeProjectView(EmployeeProjectController controller) {
        super(controller);

        createTable(List.of("Project ID", "Employee ID", "Project Name", "Department"), List.of("projectId", "employeeId", "projectName", "departmentName"));
        bindTableData(controller.getEmployeeProjects());

        //go to employee table
        Button employee = navigation("Employee Table", "Employees", () -> new EmployeeView(new EmployeeController()));

        //go to department table
        Button department = navigation("Department Table", "Departments", () -> new DepartmentView(new DepartmentController()));

        //go to projects table
        Button projects = navigation("Project Table", "Projects", () -> new ProjectsView(new ProjectController()));

        HBox navSection = navButtons(employee, department, projects); //creates a sort of div like structure for the buttons

        this.getChildren().addAll(tableView, navSection);
    }


}
