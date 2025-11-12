package com.example.mvcapplication.views;

import com.example.mvcapplication.controllers.DepartmentController;
import com.example.mvcapplication.controllers.EmployeeController;
import com.example.mvcapplication.controllers.EmployeeProjectController;
import com.example.mvcapplication.controllers.ProjectController;
import com.example.mvcapplication.models.Department;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import java.util.List;

public class DepartmentView extends AbstractView<Department, DepartmentController> {

    public DepartmentView(DepartmentController controller) {
        super(controller);

        createTable(List.of("ID", "Department Name"), List.of("id", "departmentName"));
        bindTableData(controller.getDepartments());

        //go to employee table
        VBox employeeWindow = new EmployeeView(new EmployeeController());
        Button employee = navigation("Employee Table", "Employees", employeeWindow);

        //go to projects table
        VBox projectsWindow = new ProjectsView(new ProjectController());
        Button projects = navigation("Project Table", "Projects", projectsWindow);

        //go to employee projects table
        VBox activeProjWindow = new EmployeeProjectView(new EmployeeProjectController());
        Button activeProj = navigation("Active Projects Table", "Employee Projects", activeProjWindow);

        this.getChildren().addAll(tableView);
    }

    //keep here in case this goes wrong
    /*private VBox loadNewWindow() {
        VBox pane = new VBox();
        Button employee = new Button("Employees");
        Button projects = new Button("Projects");
        Button activeProj = new Button("Active Projects");
        employee.setOnAction(e -> {
            VBox employeeWindow = new EmployeeView(new EmployeeController());
            Scene scene = new Scene(employeeWindow, 600, 400);
            Stage stage = new Stage();
            stage.setTitle("Employees");
            stage.setScene(scene);
            stage.show();
            closeCurrentWindowOnOpen(e);
        });
        projects.setOnAction( e -> {
            VBox projectsWindow = new ProjectsView(new ProjectController());
            Scene scene = new Scene(projectsWindow, 600, 400);
            Stage stage = new Stage();
            stage.setTitle("Projects");
            stage.setScene(scene);
            stage.show();
            closeCurrentWindowOnOpen(e);
        });
        activeProj.setOnAction(e -> {
            VBox activeProjWindow = new EmployeeProjectView(new EmployeeProjectController());
            Scene scene = new Scene(activeProjWindow, 600, 400);
            Stage stage = new Stage();
            stage.setTitle("Employee Projects");
            stage.setScene(scene);
            stage.show();
            closeCurrentWindowOnOpen(e);
        });
        pane.getChildren().addAll(employee, projects, activeProj);
        return pane;
    }


    private void createTable() {
        TableColumn<Department, String> departmentId = new TableColumn<>("ID");
        departmentId.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<Department, String> departmentName = new TableColumn<>("Department Name");
        departmentName.setCellValueFactory(new PropertyValueFactory<>("departmentName"));
        tableView.getColumns().addAll(departmentId, departmentName);
    }

    private void bindTableData() {
        tableView.setItems(controller.getDepartments());
    }*/

}
