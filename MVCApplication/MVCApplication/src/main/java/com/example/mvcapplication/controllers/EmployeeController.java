package com.example.mvcapplication.controllers;

import com.example.mvcapplication.models.DatabaseManager;
import com.example.mvcapplication.models.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EmployeeController {

    public EmployeeController() {

    }

    public ObservableList<Employee> getEmployees() {
        return DatabaseManager.getAllEmployees();
    }
    public ObservableList<Employee> getEmployeesByFirstName(String name) {
        return DatabaseManager.getEmployeeByFirstName(name);
    }
}
