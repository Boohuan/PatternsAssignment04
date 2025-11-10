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
    public ObservableList<Employee> getEmployeesByFirstName(String firstName) {
        return DatabaseManager.getEmployeeByFirstName(firstName);
    }

    public ObservableList<Employee> getEmployeesByLastName(String lastName){
        return DatabaseManager.getEmployeeLastName(lastName);
    }
}
