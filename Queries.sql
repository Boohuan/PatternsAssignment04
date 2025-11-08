create database hr;
use hr;

CREATE table Department(id int primary key, departmentName varchar(30));
INSERT into Department(id, departmentName) values (1, 'Human Resources'),
(2, 'Finance'),
(3, 'Information Technology'),
(4, 'Marketing'),
(5, 'Sales'),
(6, 'Operations'),
(7, 'Customer Support'),
(8, 'Research and Development'),
(9, 'Legal'),
(10, 'Administration');

CREATE TABLE Projects(
    id INT PRIMARY KEY,
    projectName VARCHAR(20),
    description VARCHAR(50),
    departmentId INT,
    CONSTRAINT fk_department_id FOREIGN KEY (departmentId) REFERENCES Department(id)
);

insert into Projects (id, projectName, description, departmentId) values
(1,'Onboarding', 'Employee onboarding automation system', 100),
(2,'Budget 2025', 'Annual budget planning and forecasting', 102),
(3,'IT Revamp', 'Upgrade internal IT infrastructure', 103),
(4,'Ad Campaign', 'New product marketing campaign', 104),
(5,'Sales Boost', 'CRM system to increase sales efficiency', 105);
