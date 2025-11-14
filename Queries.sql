    CREATE DATABASE hr;
USE hr;

CREATE TABLE Department (
    DepartmentId INT AUTO_INCREMENT PRIMARY KEY, 
    DepartmentName VARCHAR(30)
);

INSERT INTO Department (DepartmentName) VALUES 
('Human Resources'),
('Finance'),
('Information Technology'),
('Marketing'),
('Sales'),
('Operations'),
('Customer Support'),
('Research and Development'),
('Legal'),
('Administration');

CREATE TABLE Projects (
    ProjectID INT AUTO_INCREMENT PRIMARY KEY,
    ProjectName VARCHAR(20),
    ProjectDescription VARCHAR(50)
);

ALTER TABLE Projects AUTO_INCREMENT = 100;

INSERT INTO Projects (ProjectName, ProjectDescription) VALUES
('Onboarding', 'Employee onboarding automation system'),
('Budget 2025', 'Annual budget planning and forecasting'),
('IT Revamp', 'Upgrade internal IT infrastructure'),
('Ad Campaign', 'New product marketing campaign'),
('Sales Boost', 'CRM system to increase sales efficiency');

CREATE TABLE Employee (
    EmployeeID INT AUTO_INCREMENT PRIMARY KEY,
    First_Name VARCHAR(30),
    Last_Name VARCHAR(30),
    Salary DECIMAL(10,2),
    DepartmentId INT,
    ProjectID INT,
    CONSTRAINT fk_department_id FOREIGN KEY (DepartmentId) REFERENCES Department(DepartmentId),
    CONSTRAINT fk_projects_id FOREIGN KEY (ProjectID) REFERENCES Projects(ProjectID)

);

ALTER TABLE Employee AUTO_INCREMENT = 100;

INSERT INTO Employee (First_Name, Last_Name, Salary, DepartmentId, ProjectID) VALUES
('John', 'Doe', 60000.00, 1, 100),
('Jane', 'Smith', 75000.00, 2, 101),
('Michael', 'Johnson', 80000.00, 3, 102),
('Emily', 'Davis', 72000.00, 4, 103),
('Daniel', 'Wilson', 68000.00, 5, 104);

CREATE TABLE EmployeeProject (
    EmployeeID INT,
    ProjectID INT,
    FOREIGN KEY (EmployeeID) REFERENCES Employee(EmployeeID),
    FOREIGN KEY (ProjectID) REFERENCES Projects(ProjectID)
);

INSERT INTO EmployeeProject VALUES
(100, 100),
(100, 101),
(101, 102),
(102, 101),
(102, 100);