package com.example.mvcapplication.models;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EmployeeProjects {

    private final IntegerProperty projectId;
    private final IntegerProperty employeeId;
    private final StringProperty projectName;
    private final StringProperty departmentName;

    public EmployeeProjects(int projectId, int employeeId, String projectName, String departmentName) {
        this.projectId = new SimpleIntegerProperty(projectId);
        this.employeeId = new SimpleIntegerProperty(employeeId);
        this.projectName = new SimpleStringProperty(projectName);
        this.departmentName = new SimpleStringProperty(departmentName);
    }

    public IntegerProperty projectIdProperty(){
        return projectId;
    }

    public IntegerProperty employeeIdProperty(){
        return employeeId;
    }

    public StringProperty projectNameProperty(){
        return projectName;
    }

    public StringProperty departmentNameProperty(){
        return departmentName;
    }
}
