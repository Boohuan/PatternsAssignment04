package com.example.mvcapplication.controllers;

import com.example.mvcapplication.models.DatabaseManager;
import com.example.mvcapplication.models.EmployeeProjects;
import javafx.collections.ObservableList;

public class EmployeeProjectController {

    public EmployeeProjectController() {

    }

    public ObservableList<EmployeeProjects> getEmployeeProjects() {
        return DatabaseManager.getAllEmployeeProjects();
    }


}
