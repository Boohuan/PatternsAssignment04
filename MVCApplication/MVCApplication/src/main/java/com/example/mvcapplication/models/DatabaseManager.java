package com.example.mvcapplication.models;

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
     * Returns all projects from the Project table
     * @return
     */
    public static ObservableList<Projects> getAllProjects(){
        ObservableList<Projects> projects = FXCollections.observableArrayList();
        String query = "SELECT * FROM projects";
        try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement stat = conn.createStatement();
        ResultSet set = stat.executeQuery(query)){
            while(set.next()){
                projects.add(new Projects(set.getInt("id"), set.getString("projectName"), set.getString("description"), set.getInt("departmentId")));
            }
        } catch (SQLException e) {
            e.printStackTrace(); //maybe add logger if time
        }
        return projects;
    }

    /**
     * Return all departments from the Department table
     * @return
     */
    public static ObservableList<Department> getAllDepartments(){
        ObservableList<Department> departments = FXCollections.observableArrayList();
        String query = "SELECT * FROM department";
        try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement stat = conn.createStatement();
        ResultSet set = stat.executeQuery(query)){
            while(set.next()){
                departments.add(new Department(set.getInt("DepartmentId"), set.getString("DepartmentName")));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return departments;
    }

    /**
     * Gets all projects worked on by employees
     * @return
     */
    public static ObservableList<EmployeeProject> getAllEmployeeProjects(){
        ObservableList<EmployeeProject> employeeProjects = FXCollections.observableArrayList();
        String query = "SELECT projects.id, projects.projectName FROM projects JOIN employees ON projects.id = employees.id JOIN department ON employees.departmentId = department.id"; //fix
        try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement stat = conn.createStatement();
        ResultSet set = stat.executeQuery(query)){
            while(set.next()){
                employeeProjects.add(new EmployeeProject(set.getInt("projectId"), set.getInt("employeeId"), set.getString("projectName"), set.getString("departmentName")));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return employeeProjects;
    }
}
