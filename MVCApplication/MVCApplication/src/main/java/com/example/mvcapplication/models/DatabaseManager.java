package com.example.mvcapplication.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DatabaseManager {

    private static final String URL = "jdbc:mysql://localhost:3306/hr";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static ObservableList<Employee> getAllEmployees() {
        ObservableList<Employee> employees = FXCollections.observableArrayList();

        String query = "SELECT * FROM employees";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                employees.add(new Employee(
                        rs.getInt("Id"),
                        rs.getString("First_Name"),
                        rs.getString("Last_Name"),
                        rs.getDouble("Salary"),
                        rs.getInt("Department")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public static ObservableList<Employee> getEmployeeByFirstName(String firstName) {
        ObservableList<Employee> employees = FXCollections.observableArrayList();

        String query = "SELECT * FROM employees WHERE First_Name = '" + firstName + "'";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                employees.add(new Employee(
                        rs.getInt("Id"),
                        rs.getString("First_Name"),
                        rs.getString("Last_Name"),
                        rs.getDouble("Salary"),
                        rs.getInt("Department")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
