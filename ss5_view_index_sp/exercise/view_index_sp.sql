create database demo;
use demo;
create table product
(
id int primary key auto_increment,
product_code varchar(50),
product_name varchar(50),
product_price double,
product_amount int,
product_description varchar(50),
product_status varchar(50)

);
insert into product(product_code,product_name,product_price,product_amount,product_description,product_status) values
('s2','xe may',30000000,5,'nhap khau','moi'),
('s5','xe dap',5000000,8,'nhap khau','moi'),
('s7','xe dien',10000000,17,'nhap khau','moi'),
('s8','xe lan',15000000,3,'nhap khau','moi'),
('s10','xe hoi',300000000,6,'nhap khau','moi');


-- buoc 3
create unique index i_prod_code on product (product_code);
create index i_prd_name_and_price on product(product_name,product_price);
explain select product_price from product
where product_code = 's10';
drop index i_prod_code on product ;


-- bươc 4
create view w_product as
select product_code,product_name,product_price,product_status from product;

update w_product p
set product_status = 'cu'
where product_code ='s10';

drop view w_product ;




-- bươc 5
-- tạo procedure display_product
delimiter //
create procedure display_product()
begin
select*from product;
end //
delimiter ;

call display_product()


-- tạo procedure add_product
delimiter //
create procedure add_product( pc varchar(50),pn varchar(50),pp double,pa int,
						pd varchar(50),ps varchar(50)) 
begin
insert into  product( product_code,product_name,product_price,product_amount,product_description,product_status) 
					values(pc,pn,pp,pa,pd,ps);
end //
delimiter ;

call add_product(1,2,3,4,5,6);


-- sửa thông tin sản phẩm theo id
delimiter //
 create procedure edit_product_by_id( id int , pn varchar(50))
 begin
update product p
set product_name = pn
where  p.id = id; 
end //
delimiter ;
call edit_product_by_id( 6 , 'ngoc trinh')



-- xóa theo id
delimiter //
create procedure delete_by_id(id int)
begin
delete from product p 
where p.id = id;
end //
  delimiter ;
call delete_by_id(2)