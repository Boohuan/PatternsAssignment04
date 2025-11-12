package com.example.mvcapplication.views;

import com.example.mvcapplication.controllers.DepartmentController;
import com.example.mvcapplication.controllers.EmployeeController;
import com.example.mvcapplication.controllers.EmployeeProjectController;
import com.example.mvcapplication.controllers.ProjectController;
import com.example.mvcapplication.models.EmployeeProject;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.List;

public class EmployeeProjectView extends AbstractView<EmployeeProject, EmployeeProjectController> {

    public EmployeeProjectView(EmployeeProjectController controller) {
        super(controller);

        createTable(List.of("Project ID", "Employee ID", "Project Name", "Department"), List.of("projectId", "employeeId", "projectName", "departmentName"));
        bindTableData(controller.getEmployeeProjects());

        //go to employee table
        VBox employeeWindow = new EmployeeView(new EmployeeController());
        Button employee = navigation("Employee Table", "Employees", employeeWindow);

        //go to department table
        VBox departmentWindow = new DepartmentView(new DepartmentController());
        Button department = navigation("Department Table", "Departments", departmentWindow);

        //go to projects table
        VBox projectsWindow = new ProjectsView(new ProjectController());
        Button projects = navigation("Project Table", "Projects", projectsWindow);

        this.getChildren().addAll(tableView);
    }


}
