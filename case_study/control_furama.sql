
use quan_ly_furama;
-- task 1

select * from nhan_vien
where  ho_ten rlike '^[HTK]' and char_length(ho_ten)<16;
-- where  ho_ten regexp '\\w+\\s[H,K,T][a-z]+$';


-- task 2

select* from khach_hang
where  ( (year(now())-year(ngay_sinh) >18) and( year(now())-year(ngay_sinh)<50))
and (dia_chi like'%Đà Nẵng%' or dia_chi like'%Quảng Trị%') ; 

-- task 3

select  hop_dong.ma_khach_hang,ho_ten,count(hop_dong.ma_khach_hang) as so_lan_dat_phong from khach_hang,hop_dong,loai_khach
where khach_hang.ma_khach_hang=hop_dong.ma_khach_hang 
and khach_hang.ma_loai_khach = loai_khach.ma_loai_khach 
and   loai_khach.ten_loai_khach="Diamond"
group by hop_dong.ma_khach_hang 
order by so_lan_dat_phong asc; 


-- task 4

select  hop_dong.ma_khach_hang,ho_ten,count(hop_dong.ma_khach_hang) as so_lan_dat_phong
from khach_hang inner join (hop_dong,loai_khach) on khach_hang.ma_khach_hang=hop_dong.ma_khach_hang 
and khach_hang.ma_loai_khach = loai_khach.ma_loai_khach 
where ten_loai_khach="Diamond"
group by hop_dong.ma_khach_hang 
order by so_lan_dat_phong asc; 


-- task 5

-- select kh.ma_khach_hang,ho_ten,ten_loai_khach,hdct.ma_hop_dong,ten_dich_vu,ngay_lam_hop_dong,ngay_ket_thuc,(chi_phi_thue+so_luong*gia)as tong 
select kh.ma_khach_hang,ho_ten,ten_loai_khach,hd.ma_hop_dong,ten_dich_vu,ngay_lam_hop_dong,ngay_ket_thuc,ifnull(chi_phi_thue+(so_luong*gia),chi_phi_thue) as tong_tien
from khach_hang kh 
left join hop_dong hd on kh.ma_khach_hang=hd.ma_khach_hang 
left join hop_dong_chi_tiet hdct on hd.ma_hop_dong=hdct.ma_hop_dong
left join dich_vu_di_kem dvdk on  hdct. ma_dich_vu_di_kem=dvdk.ma_dich_vu_di_kem
left join loai_khach lk on lk.ma_loai_khach = kh.ma_loai_khach
left join dich_vu dv on hd.ma_dich_vu=dv.ma_dich_vu
;
select kh.ma_khach_hang,ho_ten,hd.ma_hop_dong
from khach_hang kh 
left join hop_dong hd on kh.ma_khach_hang=hd.ma_khach_hang 
left join hop_dong_chi_tiet hdct on hd.ma_hop_dong=hdct.ma_hop_dong
left join dich_vu_di_kem dvdk on  hdct. ma_dich_vu_di_kem=dvdk.ma_dich_vu_di_kem
left join loai_khach lk on lk.ma_loai_khach = kh.ma_loai_khach
left join dich_vu dv on hd.ma_dich_vu=dv.ma_dich_vu 
;

-- task 6
select  hd.ma_dich_vu ,ten_dich_vu,dien_tich,chi_phi_thue,ten_loai_dich_vu from  dich_vu dv
join  loai_dich_vu ldv on ldv.ma_loai_dich_vu = dv.ma_loai_dich_vu
join hop_dong hd on hd.ma_dich_vu=dv.ma_dich_vu
where hd.ma_dich_vu not in(
select dv. ma_dich_vu from hop_dong hd join dich_vu dv on   hd.ma_dich_vu=dv.ma_dich_vu
where month(ngay_lam_hop_dong) in(1,2,3) and year(ngay_lam_hop_dong) =2021)
 group by  hd.ma_dich_vu ;
;


-- task 7 --

select dv.ma_dich_vu,ten_dich_vu,dien_tich,so_nguoi_toi_da,chi_phi_thue,ten_loai_dich_vu from dich_vu dv
join loai_dich_vu ldv on ldv.ma_loai_dich_vu = dv.ma_loai_dich_vu
 WHERE (dv.ma_dich_vu in (SELECT ma_dich_vu FROM hop_dong WHERE year(ngay_lam_hop_dong) = 2020)) and (dv.ma_dich_vu
 not in (SELECT ma_dich_vu FROM hop_dong WHERE year(ngay_lam_hop_dong) = 2021));
;

-- task 8
-- select ho_ten from khach_hang


-- task 9
select month(ngay_lam_hop_dong),count(ma_dich_vu) so_luong_khach_hang from hop_dong
where year(ngay_lam_hop_dong)=2021
group by month(ngay_lam_hop_dong)
order by month(ngay_lam_hop_dong) asc ;


-- task 10
select hd. ma_hop_dong,ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc,sum(hdct.so_luong) as so_luong_dich_vu_di_kem from hop_dong hd
left join hop_dong_chi_tiet hdct on hdct.ma_hop_dong= hd.ma_hop_dong
left join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
group by hd. ma_hop_dong ;

-- task 11 --
select dvdk.* from dich_vu_di_kem dvdk
join   hop_dong_chi_tiet hdct  on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
join hop_dong hd on hdct.ma_hop_dong= hd.ma_hop_dong
join khach_hang kh on kh.ma_khach_hang = hd.ma_khach_hang 
join loai_khach lk on lk.ma_loai_khach = kh.ma_loai_khach
where ten_loai_khach = 'Diamond' and (dia_chi like'%Vinh%'or dia_chi like '%Quảng Ngãi%'); 


-- task 12 ---
select hd.ma_hop_dong,nv.ho_ten ten_nv,kh.ho_ten ten_kh,kh.so_dien_thoai,ten_dich_vu,sum(so_luong) so_luong_dich_vu_dinh_kem,tien_dat_coc from hop_dong hd
left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
join dich_vu dv on dv.ma_dich_vu = hd.ma_dich_vu
join khach_hang kh on kh.ma_khach_hang = hd .ma_khach_hang
join nhan_vien nv on nv.ma_nhan_vien = hd.ma_nhan_vien
 where  ( quarter(ngay_lam_hop_dong) = 4 and year(ngay_lam_hop_dong) =2020) and 
 ngay_lam_hop_dong  not in (select ngay_lam_hop_dong from hop_dong 
 where (quarter(ngay_lam_hop_dong) = 1 or quarter(ngay_lam_hop_dong) = 2 and year(ngay_lam_hop_dong) =2021))
group by hd.ma_hop_dong
;

-- task 13 
select dvdk.* , sum(so_luong) as so_luong_dich_vu_di_kem from dich_vu_di_kem dvdk 
join hop_dong_chi_tiet hdct on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
group by ma_dich_vu_di_kem
having so_luong_dich_vu_di_kem  =(select sum(so_luong) from hop_dong_chi_tiet group by  ma_dich_vu_di_kem  order by sum(so_luong) desc  limit 1 ) ;


-- task 14
select hd.ma_hop_dong,ten_loai_dich_vu,ten_dich_vu_di_kem ,count(hdct.ma_dich_vu_di_kem) so_lan_su_dung from hop_dong hd
join dich_vu dv on dv.ma_dich_vu = hd.ma_dich_vu 
join loai_dich_vu ldv on ldv.ma_loai_dich_vu = dv.ma_dich_vu
join hop_dong_chi_tiet hdct  on hd.ma_hop_dong= hdct.ma_hop_dong
join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
group by hdct. ma_dich_vu_di_kem
having count(hdct.ma_dich_vu_di_kem) = 1;

-- task 15
 select   nv.ma_nhan_vien,ho_ten,td.ten_trinh_do,bp.ten_bo_phan,so_dien_thoai,dia_chi,count(hd.ma_nhan_vien) as so_luong_hop_dong from nhan_vien nv
 join hop_dong hd on hd.ma_nhan_vien = nv.ma_nhan_vien
 join bo_phan bp on bp.ma_bo_phan = nv.ma_bo_phan
 join trinh_do td  on  nv.ma_trinh_do= td.ma_trinh_do
 where year(ngay_lam_hop_dong) = 2020  or year(ngay_lam_hop_dong) = 2021
 group by ma_nhan_vien
 having count(hd.ma_nhan_vien) <=3;

 
-- task 16
delete  from nhan_vien nv
where nv.ma_nhan_vien not in
(select hd.ma_nhan_vien from hop_dong hd 
where  year(ngay_lam_hop_dong) between 2019 and 2021);



-- task 17-- tìm khách hàng
select kh.*, chi_phi_thue+(so_luong*gia) as tong_tien_thanh_toan from khach_hang kh
join hop_dong hd on hd.ma_khach_hang = kh.ma_khach_hang
join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
join hop_dong_chi_tiet hdct on hdct.ma_hop_dong = hd.ma_hop_dong
join dich_vu_di_kem dvdt on hdct.ma_dich_vu_di_kem = dvdt.ma_dich_vu_di_kem 
where ma_loai_khach  in ( select ma_loai_khach from loai_khach where ten_loai_khach = 'Platinium') and year(hd.ngay_lam_hop_dong)=2021
group by ma_khach_hang
having tong_tien_thanh_toan > 10000000;
-- task 17 -- up date khach hang 
update  khach_hang kh
set kh.ma_loai_khach = 1 
where kh. ma_khach_hang in (select ma_khach_hang from  (select kh.ma_khach_hang from khach_hang kh
join hop_dong hd on hd.ma_khach_hang = kh.ma_khach_hang
join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
join hop_dong_chi_tiet hdct on hdct.ma_hop_dong = hd.ma_hop_dong
join dich_vu_di_kem dvdt on hdct.ma_dich_vu_di_kem = dvdt.ma_dich_vu_di_kem 
where ma_loai_khach  in ( select ma_loai_khach from loai_khach where ten_loai_khach = 'Platinium' and year(hd.ngay_lam_hop_dong)=2021 
and chi_phi_thue+(so_luong*gia) > 10000000 )
group by ma_khach_hang)as tem);

-- task 18 
delete from khach_hang 
where ma_khach_hang in (select hd.ma_khach_hang from hop_dong hd where year(ngay_lam_hop_dong) < 2021) ;


-- task 19
update dich_vu_di_kem dvdk
set gia = gia*2
where dvdk.ma_dich_vu_di_kem in (select ma_dich_vu_di_kem from 
(select ma_dich_vu_di_kem from hop_dong_chi_tiet hdct
group by ma_dich_vu_di_kem
having sum(hdct.so_luong)>10 )as temp);

-- task 20 
    select ma_nhan_vien ma_nv_kh ,ho_ten, email,so_dien_thoai,ngay_sinh,dia_chi from nhan_vien
    union all
    select ma_khach_hang,ho_ten, email,so_dien_thoai,ngay_sinh,dia_chi  from khach_hang;
        
       --  task 21
	create view w_nv as
      select* from  nhan_vien
      where dia_chi like '%yên bái%';
        
-- task 22
update w_nv set dia_chi = 'liên chiểu , Đà nẵng';

-- task 23 
delimiter //
create procedure sp_xoa_khach_hang ( id int )
begin
if (id not in (select ma_khach_hang from khach_hang))
then set id  = 0;
end if ;
delete from khach_hang where ma_khach_hang = id;
end //
delimiter ;

-- task 24
delimiter //
create procedure them_moi_hop_dong ( id int , d_star varchar(50) )
begin
declare error_ms varchar(250);
if (id in (select ma_khach_hang from khach_hang))
then delete from khach_hang where ma_khach_hang = id;
 else SIGNAL SQLSTATE '45000' 
            SET MESSAGE_TEXT = ' id khong ton tai' ; 
end if ;

-- delete from khach_hang where ma_khach_hang = id;
end //
delimiter ;
call sp_xoa_khach_hang ( 30 );
-- task 27
delimiter //
create function func_dem_dich_vu()
returns int 
deterministic
begin 
--  declare so_lan int;
--  set so_lan =0;
 return  (select count(ma_dich_vu)  from
(select hd.ma_dich_vu,sum(dv.chi_phi_thue) from hop_dong hd
join dich_vu dv on  dv . ma_dich_vu =  hd.ma_dich_vu
group by hd.ma_dich_vu
having sum(dv.chi_phi_thue) > 2000000)as temp ) ;

end ; //
delimiter ;


delimiter //
create trigger abc
after insert on nhan_vien
for each row 
begin 
insert  into jame(name)  values (new.ho_ten); 
end //						
delimiter ;
drop trigger abc
