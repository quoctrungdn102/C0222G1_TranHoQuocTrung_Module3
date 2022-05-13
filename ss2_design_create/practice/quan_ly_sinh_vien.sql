create database if not exists quan_ly_sinh_vien ;
use quan_ly_sinh_vien;
create table if not exists class(
class_id int not null auto_increment  primary key,
class_name varchar(60) not null,
start_day datetime not null,
`status` bit
 );
 create table if not exists student
 (
 student_id int not null auto_increment,
 primary key(student_id),
 student_name varchar(30) not null ,
 address varchar(50),
 phone varchar(20),
 `status` bit, 
 class_id int not null,
 foreign key (class_id) references class(class_id)
 );
 CREATE TABLE  if not exists `subject`
(
    sub_id   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    sub_name VARCHAR(30) NOT NULL,
    credit  TINYINT     NOT NULL DEFAULT 1 CHECK ( credit >= 1 ),
    `status`  BIT                  DEFAULT 1
);
CREATE TABLE  if not exists mark
(
    mark_id    INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    sub_id     INT NOT NULL,
    student_id INT NOT NULL,
    mark      FLOAT   DEFAULT 0 CHECK ( mark BETWEEN 0 AND 100),
    exam_times TINYINT DEFAULT 1,
    UNIQUE (sub_id, student_id),
    FOREIGN KEY (sub_id) REFERENCES `subject` (sub_id),
    FOREIGN KEY (student_id) REFERENCES Student (student_id)
);
select*from class;
select*from student;
select*from `subject`;
select*from mark;


 