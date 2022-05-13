create database if not exists quan_ly_diem_thi;
USE quan_ly_diem_thi;
CREATE TABLE IF NOT EXISTS hoc_sinh (
    ma_hs VARCHAR(20),
    ten_hs VARCHAR(20),
    ngay_sinh DATETIME,
    lop VARCHAR(10),
    PRIMARY KEY (ma_hs)
);
CREATE TABLE  if not exists  mon_hoc (
    ma_mh VARCHAR(20) PRIMARY KEY,
    ten_mh VARCHAR(50)
);
CREATE TABLE  if not exists giao_vien(
    ma_gv VARCHAR(20) PRIMARY KEY,
    ten_gv VARCHAR(20),
    sdt VARCHAR(10)
);
-- alter TABLE mon_hoc 
-- ADD  ma_gv VARCHAR(20)
-- AFTER ma_mh;
-- alter TABLE mon_hoc 
-- drop column ma_gv;
-- ALTER TABLE mon_hoc
-- add constraint pk_ma_gv foreign key (ma_gv) REFERENCES giao_vien(ma_gv);
SELECT*FROM mon_hoc;
SELECT*FROM hoc_sinh;
SELECT*FROM giao_vien;