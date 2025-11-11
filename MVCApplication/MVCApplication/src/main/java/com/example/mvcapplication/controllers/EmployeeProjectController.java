package com.example.mvcapplication.controllers;

import com.example.mvcapplication.models.DatabaseManager;
import com.example.mvcapplication.models.EmployeeProject;
import javafx.collections.ObservableList;

public class EmployeeProjectController {

    public EmployeeProjectController() {

    }

    public ObservableList<EmployeeProject> getEmployeeProjects() {
        return DatabaseManager.getAllEmployeeProjects();
    }


}
