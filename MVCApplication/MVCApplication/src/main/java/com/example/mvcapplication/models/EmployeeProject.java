package com.example.mvcapplication.models;

import javafx.beans.property.*;

public class EmployeeProject {

    private final IntegerProperty projectId;
    private final IntegerProperty employeeId;
    private final StringProperty projectName;
    private final StringProperty departmentName;

    public EmployeeProject(int projectId, int employeeId, String projectName, String departmentName) {
        this.projectId = new SimpleIntegerProperty(projectId);
        this.employeeId = new SimpleIntegerProperty(employeeId);
        this.projectName = new SimpleStringProperty(projectName);
        this.departmentName = new SimpleStringProperty(departmentName);
    }

    public IntegerProperty projectIdProperty() {
        return projectId;
    }

    public IntegerProperty employeeIdProperty() {
        return employeeId;
    }

    public StringProperty projectNameProperty() {
        return projectName;
    }

    public StringProperty departmentNameProperty() {
        return departmentName;
    }
}
