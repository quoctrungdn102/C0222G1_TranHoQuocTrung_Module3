create database if not exists quan_ly_sinh_vien ;
use quan_ly_sinh_vien;
create table if not exists class (
    class_id int not null auto_increment primary key,
    class_name varchar(60) not null,
    start_day datetime not null,
    `status` bit
);
INSERT INTO Class(class_name,start_day,`status`)
VALUES ( 'A1', '2008-12-20', 1);
INSERT INTO Class(class_name,start_day,`status`)
VALUES ( 'A2', '2008-12-22', 1);
INSERT INTO Class(class_name,start_day,`status`)
VALUES ( 'B3', current_date, 0);

create table if not exists student (
    student_id int auto_increment,
    primary key (student_id),
    student_name varchar(30) not null,
    address varchar(50),
    phone varchar(20),
    `status` bit,
    class_id int not null,
    foreign key (class_id)
        references class (class_id)
);
 
INSERT INTO Student (student_name, address, phone, `Status`, class_id)
VALUES ('Hung', 'Ha Noi', '0912113113', 1, 1);
INSERT INTO Student (student_name, address, `Status`, class_id)
VALUES ('Hoa', 'Hai phong', 1, 1);
INSERT INTO Student (student_name, address, phone, `Status`, class_id)
VALUES ('Manh', 'HCM', '0123123123', 0, 2);


CREATE TABLE if not exists `subject` (
    sub_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    sub_name VARCHAR(30) NOT NULL,
    credit TINYINT NOT NULL DEFAULT 1 CHECK (credit >= 1),
    `status` BIT DEFAULT 1
);

INSERT INTO `subject`(sub_name, credit, `status`)
VALUES ( 'CF', 5, 1);
INSERT INTO `subject`(sub_name, credit, `status`)
VALUES    ( 'C', 6, 1);
INSERT INTO `subject`(sub_name, credit, `status`)
VALUES   ( 'HDJ', 5, 1);
INSERT INTO `subject`(sub_name, credit, `status`)
VALUES  ( 'RDBMS', 10, 1);
       
CREATE TABLE if not exists mark (
    mark_id INT  AUTO_INCREMENT PRIMARY KEY,
    sub_id INT NOT NULL,
    student_id INT NOT NULL,
    mark_1 FLOAT DEFAULT 0 CHECK (mark_1 BETWEEN 0 AND 100),
    exam_times TINYINT DEFAULT 1,
    FOREIGN KEY (sub_id)
	REFERENCES `subject` (sub_id),
    FOREIGN KEY (student_id)
	REFERENCES Student (student_id)
);
INSERT INTO mark (sub_id, student_id, mark_1, exam_times)
VALUES (1, 1, 8, 1),
       (1, 2, 11, 2),
       (2, 1, 12, 1);
       
           
select*from `subject`
where credit = (select max(credit) from`subject`);

select s.sub_id,sub_name,credit,`status`,mark_1 diem_thi from `subject`s
join mark m on  m.sub_id= s.sub_id
where mark_1 = (select max(mark_1)from mark);

select s.student_id,student_name,address,phone,`status`, avg(mark_1) diem_trung_binh from student s
join mark m  on s.student_id=m.student_id
group by student_id
order by diem_trung_binh desc;
 
 create view view_stdent as
select*from student
where phone is not null
WITH CHECK OPTION;

insert into view_stdent values(12,'trung',null,61312,1,2);