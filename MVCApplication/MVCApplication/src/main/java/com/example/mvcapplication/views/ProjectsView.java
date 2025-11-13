package com.example.mvcapplication.views;

import com.example.mvcapplication.controllers.DepartmentController;
import com.example.mvcapplication.controllers.EmployeeController;
import com.example.mvcapplication.controllers.EmployeeProjectController;
import com.example.mvcapplication.controllers.ProjectController;
import com.example.mvcapplication.models.Projects;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.List;

public class ProjectsView extends AbstractView<Projects, ProjectController> {

    public ProjectsView(ProjectController controller) {
        super(controller);

        createTable(List.of("ID", "Project Name", "Description"), List.of("id", "projectName", "description"));
        bindTableData(controller.getProjects());

        //go to employee table
        Button employee = navigation("Employee Table", "Employees", () -> new EmployeeView(new EmployeeController()));

        //go to department table
        Button department = navigation("Department Table", "Departments", () -> new DepartmentView(new DepartmentController()));

        //go to employee projects table
        Button activeProj = navigation("Active Projects Table", "Employee Projects", () -> new EmployeeProjectView(new EmployeeProjectController()));

        this.getChildren().addAll(tableView);
    }
}
