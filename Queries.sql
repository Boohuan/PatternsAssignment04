create database hr;
use hr;

create sequence employee_id_seq start with 100 increment by 1 no cycle;
create table Employee(
EmployeeID int default next value for employee_id_seq primary key,
First_Name varchar(30),
Last_Name varchar(30),
Salary decimal(10,2)
DepartmentId int,
constraint fk_department_id foreign key (DepartmentId) references Department(DepartmentId));
insert into Employee(First_Name, Last_Name, Salary, DepartmentId) values
()

create sequence department_id_seq start with 100 increment by 1 no cycle;
CREATE table Department(
DepartmentId int default next value for department_id_seq primary key, 
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


create sequence project_id_seq start with 100 increment by 1 no cycle;
CREATE TABLE Projects(
    ProjectID INT default next value for project_id_seq PRIMARY KEY,
    ProjectName VARCHAR(20),
    ProjectDescription VARCHAR(50));
insert into Projects (ProjectName, ProjectDescription) values
('Onboarding', 'Employee onboarding automation system'),
('Budget 2025', 'Annual budget planning and forecasting'),
('IT Revamp', 'Upgrade internal IT infrastructure'),
('Ad Campaign', 'New product marketing campaign'),
('Sales Boost', 'CRM system to increase sales efficiency');
