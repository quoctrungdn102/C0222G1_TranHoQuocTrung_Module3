create database if not exists quan_ly_ban_hang;
use quan_ly_ban_hang;
create table if not exists customer
(
c_id int primary key,
c_name char(50),
c_age int
);
create table if not exists product
(
p_id int primary key,
p_name varchar(50),
p_price double
);

create table if not exists `order`
(
o_id int primary key,
c_id int,
od_qty char(50),
foreign key (c_id)references customer(c_id)
);
create table if not exists order_detail
(
o_id int,
p_id int,
primary key(o_id,p_id),
od_qty char(50),
foreign key (p_id)references product(p_id),
foreign key (o_id)references `order`(o_id)
);




