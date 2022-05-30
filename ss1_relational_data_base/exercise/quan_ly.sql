CREATE database  if not exists student_management;
use student_management;
create table if not exists class(
id INT UNIQUE ,
`name` VARCHAR(50));
insert into  class  VALUES(2,"trung")  ;
create table if not exists teacher (
id INT,
`name` VARCHAR(50),
age INT,
country varchar(50) 
);
select * from class;
SELECT * from teacher;
