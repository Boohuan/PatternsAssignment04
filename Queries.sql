create database hr;
use hr;

CREATE table Department(
DepartmentId int auto_increment primary key, 
DepartmentName varchar(30));
INSERT into Department(DepartmentName) values 
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

create table Employee(
EmployeeID int auto_increment primary key,
First_Name varchar(30),
Last_Name varchar(30),
Salary decimal(10,2),
DepartmentId int,
constraint fk_department_id foreign key (DepartmentId) references Department(DepartmentId));
insert into Employee(First_Name, Last_Name, Salary, DepartmentId) values
('John', 'Doe', 60000.00, 1),
('Jane', 'Smith', 75000.00, 2),
('Peter', 'Jones', 85000.00, 3);


CREATE TABLE Projects(
    ProjectID INT auto_increment PRIMARY KEY,
    ProjectName VARCHAR(20),
    ProjectDescription VARCHAR(50));
insert into Projects (ProjectName, ProjectDescription) values
('Onboarding', 'Employee onboarding automation system'),
('Budget 2025', 'Annual budget planning and forecasting'),
('IT Revamp', 'Upgrade internal IT infrastructure'),
('Ad Campaign', 'New product marketing campaign'),
('Sales Boost', 'CRM system to increase sales efficiency');

create table EmployeeProject(
EmployeeID int,
ProjectID int,
constraint fk_employee_id foreign key (EmployeeID) references Employee(EmployeeID),
constraint fk_project_id foreign key (ProjectID) references Projects(ProjectID));
insert into EmployeeProject(EmployeeID, ProjectID) values
(1, 101), --fix this part
(2, 100),
(3, 102),
(4, 101);