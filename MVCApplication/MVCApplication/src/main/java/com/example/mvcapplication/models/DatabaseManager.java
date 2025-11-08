package com.example.mvcapplication.models;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DatabaseManager {

    private static final String URL = "jdbc:mysql://localhost:3306/hr"; //the database
    private static final String USER = "root"; //username
    private static final String PASSWORD = ""; //password

    /**
     * Returns everything in the employee table
     * @return
     */
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

    /**
     * Returns the first name of every employee in the employee table
     * @param firstName
     * @return
     */
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

    /**
     * Gets all employee last names from the employee table
     * @param lastName
     * @return
     */
    public static ObservableList<Employee> getEmployeeLastName(String lastName){
        ObservableList<Employee> employees = FXCollections.observableArrayList();
            String query = "SELECT * FROM employees WHERE Last_Name = '" + lastName + "'";
            try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stat = conn.createStatement();
            ResultSet set = stat.executeQuery(query)) {
                while(set.next()) {
                    employees.add(new Employee(set.getInt("Id"), set.getString("First_Name"), set.getString("Last_Name"), set.getDouble("Salary"), set.getInt("Department")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return employees;
    }
}
