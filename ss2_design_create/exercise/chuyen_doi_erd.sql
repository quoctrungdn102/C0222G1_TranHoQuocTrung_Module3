create database if not exists quan_ly_vat_tu;
use quan_ly_vat_tu;
create table if not exists vat_tu
(
ma_vat_tu int  auto_increment primary key,
ten_vat_tu varchar(50)
); 
insert into vat_tu(ten_vat_tu) values("xe rua");
create table if not exists phieu_nhap
(
so_pn int auto_increment primary key,
ngay_nhap datetime
);
insert into phieu_nhap(ngay_nhap) values("1999/10/10");
create table if not exists phieu_xuat
(so_px int auto_increment primary key,
ngay_xuat datetime
);
insert into phieu_xuat(ngay_xuat) values("1999/11/11");

create table if not exists don_dat_hang
(
so_dh int auto_increment primary key,
ngay_dh datetime
);
insert into don_dat_hang(ngay_dh) values("1999/12/21");
create table if not exists chi_tiet_phieu_xuat
(
so_px int,
ma_vat_tu int,
unique(so_px,ma_vat_tu),
dg_xuat double,
sl_xuat int,
foreign key(so_px)references phieu_xuat(so_px),
foreign key(ma_vat_tu)references vat_tu(ma_vat_tu)
);
-- insert into chi_tiet_phieu_xuat values(1,1,25.000,2);

create table if not exists chi_tiet_phieu_nhap
(
so_pn int,
ma_vat_tu int,
unique(so_pn,ma_vat_tu),
dg_nhap double,
sl_nhap int,
foreign key(so_pn)references phieu_nhap(so_pn),
foreign key(ma_vat_tu)references vat_tu(ma_vat_tu)
);
-- insert into chi_tiet_phieu_nhap values(1,1,24.000,10);

create table if not exists chi_tiet_don_dh
(
so_dh int,
ma_vat_tu int,
foreign key(so_dh)references don_dat_hang(so_dh),
foreign key(ma_vat_tu)references vat_tu(ma_vat_tu)
);
insert into chi_tiet_don_dh values(1,2);
create table if not exists so_dien_thoai_ncc
(
id_sdt int auto_increment primary key,
sdt varchar(10)
);
insert into so_dien_thoai_ncc(sdt) values("0128358212");
create table if not exists cung_cap
(
ma_ncc  int auto_increment primary key,
ten_ncc varchar(25),
dia_chi varchar(100),
so_dh int,
id_sdt int,
foreign key(so_dh)references don_dat_hang(so_dh),
foreign key(id_sdt)references so_dien_thoai_ncc(id_sdt)

);

insert into cung_cap(ten_ncc,dia_chi,so_dh,id_sdt) values("trung tran","dn",1,1);

