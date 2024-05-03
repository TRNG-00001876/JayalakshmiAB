use Rev_console;
drop table users;
drop table Employee;



create table users(
userid int identity(1,1) primary key,
username varchar(20),
userpassword varchar(20),
useremail varchar(30),
user_phoneno bigint);

select*from users;

create table Employee(
emp_id int,
Firstname varchar(20),
Lastname varchar(30),
Email varchar(20),
Position varchar(20),
Department varchar(20),
Salary int);
select *from Employee;
ALTER TABLE Employee
ADD emp_key int;
Alter TABLE users
ADD user_phoneno int;

CREATE TABLE Resumes (
    ResumeID int identity(1,1)primary key,
	userid int,
    firstname VARCHAR(100),
    Lastname VARCHAR(100),
    dob date,
	mail varchar(20),
	phoneno bigint, 
    highereducation varchar(20),
    marks int);

	select*from Resumes;

	CREATE TABLE JobListings (
    JobID INT PRIMARY KEY,
    JobTitle VARCHAR(100),
    Companyname VARCHAR(100),
    Loc VARCHAR(100),
    experience INT);

	select*from JobListings;
	drop table users;
	drop table Resumes;

	drop table JobListings;
	create table JobListings(
	JobID int primary key,
	JobTitle varchar(20),
	Companyname varchar(20),
	Loc varchar(30),
	experience int);
	
	create table Applicant(
	Applicantid int identity(1,1)primarykey
	Applicantname varchar(20),
	Applicantmail varchar(30));


