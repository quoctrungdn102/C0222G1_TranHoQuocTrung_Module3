create database if not exists quan_ly_ban_hang;
use quan_ly_ban_hang;
create table if not exists customer
(
c_id int primary key auto_increment,
`name` varchar(25),
c_age tinyint 
);

insert into customer (name,c_age) 
values('MInh Quan',10),
	  ('Ngoc Oanh',20),
	  ('Hong Ha',50);
      
create table if not exists `order`
(
o_id int primary key auto_increment,
c_id int,
o_date datetime,
o_total_price int,
foreign key (c_id)references customer(c_id)
);

insert into  `order`(c_id,o_date,o_total_price)values
(1,'2006/3/21',null),
(2,'2006/3/23',null),
(1,'2006/3/16',null);

create table if not exists product
(
p_id int primary key auto_increment,
p_name varchar(25),
p_price int
);
insert into product(p_name,p_price) 
values('May Giat',3),
	  ('Tu Lanh',5),
	  ('Dieu Hoa',7),
	  ('Quat',1),
	  ('Bep Dien',2);
create table if not exists order_detail
(
o_id int,
p_id int,
primary key(o_id,p_id),
od_qty int,
foreign key (p_id)references product(p_id),
foreign key (o_id)references `order`(o_id)
);

insert into order_detail values
 (1,1,3),
 (1,3,7),
 (1,4,2),
 (2,1,1),
 (3,1,8),
 (2,5,4),
 (2,3,3); 
 
 select o_id,o_date,o_total_price from `order`;
 
 select `order`.c_id,`name`,p_name 
 from (customer) join `order` on customer.c_id = `order`.c_id
					     join order_detail on ( `order`.o_id=order_detail.o_id )
                         join product on product.p_id=order_detail.p_id;
                         
select c_id,`name`
from customer 
where c_id not in (select `order`.c_id from `order`) ;

select od.o_id,o_date,sum(od_qty*p_price) as gia_tien 
from order_detail od
join product p on od.p_id= p.p_id
join `order` o on od.o_id= o.o_id
group by od.o_id ;
  
