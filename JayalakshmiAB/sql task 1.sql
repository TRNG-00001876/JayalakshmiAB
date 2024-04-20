use employee
create table Employee(
empcode int,
emp_fname varchar(30),
emp_lastname varchar(30),
job varchar(80),
Manager varchar(20),
Hiredate date,
salary int,
commission int,
deptcode int);


create table dept(
deptcode int,
dept_name varchar(30),
dept_loc varchar(20));
select * from dept

Alter table dept
Alter column deptcode int not null;
Alter table dept add constraint PK_deptcode PRIMARY KEY (deptcode);
Alter table dept add constraint uniqueid_dept_name UNIQUE (dept_name);

Alter table dept
add loc varchar(20);

Alter table Employee add constraint Pk_empcode PRIMARY KEY (empcode);
Alter table Employee add constraint fk_deptcode FOREIGN KEY REFERENCES deptcode(deptcode);

INSERT INTO dept VALUES (10, 'FINANCE', 'EDINBURGH'),
                              (20,'SOFTWARE','PADDINGTON'),
                              (30, 'SALES', 'MAIDSTONE'),
                              (40,'MARKETING', 'DARLINGTON'),
                              (50,'ADMIN', 'BIRMINGHAM');
Insert into Employee values(9369, 'TONY', 'STARK', 'SOFTWARE ENGINEER', 7902, '1980-12-17', 2800,0,20),
       (9499, 'TIM', 'ADOLF', 'SALESMAN', 7698, '1981-02-20', 1600, 300,30),    
       (9566, 'KIM', 'JARVIS', 'MANAGER', 7839, '1981-04-02', 3570,0,20),
       (9654, 'SAM', 'MILES', 'SALESMAN', 7698, '1981-09-28', 1250, 1400, 30),
       (9782, 'KEVIN', 'HILL', 'MANAGER', 7839, '1981-06-09', 2940,0,10),
       (9788, 'CONNIE', 'SMITH', 'ANALYST', 7566, '1982-12-09', 3000,0,20),       (9839, 'ALFRED', 'KINSLEY', 'PRESIDENT', 7566, '1981-11-17', 5000,0, 10),
       (9844, 'PAUL', 'TIMOTHY', 'SALESMAN', 7698, '1981-09-08', 1500,0,30),
       (9876, 'JOHN', 'ASGHAR', 'SOFTWARE ENGINEER', 7788, '1983-01-12',3100,0,20),
       (9900, 'ROSE', 'SUMMERS', 'TECHNICAL LEAD', 7698, '1981-12-03', 2950,0, 20),
       (9902, 'ANDREW', 'FAULKNER', 'ANAYLYST', 7566, '1981-12-03', 3000,0, 10),
       (9934, 'KAREN', 'MATTHEWS', 'SOFTWARE ENGINEER', 7782, '1982-01-23', 3300,0,20),
       (9591, 'WENDY', 'SHAWN', 'SALESMAN', 7698, '1981-02-22', 500,0,30),
       (9698, 'BELLA', 'SWAN', 'MANAGER', 7839, '1981-05-01', 3420, 0,30),
       (9777, 'MADII', 'HIMBURY', 'ANALYST', 7839, '1981-05-01', 2000, 200, NULL),
       (9860, 'ATHENA', 'WILSON', 'ANALYST', 7839, '1992-06-21', 7000, 100, 50),
       (9861, 'JENNIFER', 'HUETTE', 'ANALYST', 7839, '1996-07-01', 5000, 100, 50); 

	   select e.emp_fname,e.emp_lastname,d.deptcode,d.dept_name,d.dept_loc
	   from Employee e
	   join dept d on e.deptcode=d.deptcode
	   order by e.emp_fname asc ,d.dept_loc asc;

	   select emp_fname,salary+commission as "total salary"
	   from Employee;

	   select max(salary) as "HIGH SALARY" from Employee;

	   select salary from Employee order by salary desc offset 0 row fetch next 3 rows only;

	   select distinct top 2 salary as "maximum salary" from Employee order by salary desc;

	   select * from Employee;
	   select salary+commission as "high sal" from Employee where job='ANALYST' and deptcode=20;

	   /*Compute the average, minimum, and maximum salaries of the group of employees having the job of ANALYST.*/
select avg(salary) as"average_salary",min(salary) as "minimum_salary" , max(salary)as "max_salary" 
from Employee
where job='Analyst';

/*	Query to find all departments that are located in Edinburgh:*/

select * from Employee
select * from dept
select* from dept where dept_loc='Edinburgh'
select * from Employee e INNER JOIN dept d on e.deptcode=d.deptcode 
where dept_loc='Edinburgh';

select * from employee 
select * from dept
select * from Employee e left JOIN dept d on e.deptcode=d.deptcode
where dept_name='finance';

/*Query to find the average salary of employees in each department:*/


select d.dept_name ,avg(e.salary)as avg_salary from Employee e INNER JOIN
 dept d on e.deptcode=d.deptcode group by dept_name;

/*Query to find the top 10 highest-paid employees:*/
select top 10 emp_fname,salary from Employee order by salary desc;

/*Return a list of all employees who are paid above the average salary.*/

select emp_fname,salary from Employee 
where salary>(select avg(salary)from Employee);

/*Return a list of all employees who have been with the company for more than 5 years.*/
select * from employee
where datediff(year,hiredate,getDate())>5;

/*query to find all the employee who did not get the promotion in the last year*/
select * from Employee
where empcode not in (
select empcode
from promotions
where promotion_date>=dateadd(year,-1,getDate()));
