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
        super(new ProjectController());

        createTable(List.of("ID", "Project Name", "Description"), List.of("id", "projectName", "description"));
        bindTableData(controller.getProjects());

        //go to employee table
        VBox employeeWindow = new EmployeeView(new EmployeeController());
        Button employee = navigation("Employee Table", "Employees", employeeWindow);

        //go to department table
        VBox departmentWindow = new DepartmentView(new DepartmentController());
        Button department = navigation("Department Table", "Departments", departmentWindow);

        //go to employee projects table
        VBox activeProjWindow = new EmployeeProjectView(new EmployeeProjectController());
        Button activeProj = navigation("Active Projects Table", "Employee Projects", activeProjWindow);

        this.getChildren().addAll(tableView);
    }
}
