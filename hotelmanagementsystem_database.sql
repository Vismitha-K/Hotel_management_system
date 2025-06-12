create database hotelmanagementsystem;
use hotelmanagementsystem;

create table login(username varchar(50), password varchar(20));
insert into login values ('admin', '12345');
select * from login;

create table employees(name varchar(25), age varchar(10), gender varchar(10), job varchar(25), salary varchar(20), phoneno varchar(20), email varchar(50), aadhar varchar(30));
select * from employees;

create table rooms(roomno varchar(15), availability varchar(20), cleaning_status varchar(20), price varchar(25), bed_type varchar(20));
select * from rooms;

create table drivers(name varchar(25), age varchar(20), gender varchar(20), car_company varchar(25), car_model varchar(20), availability varchar(20), location varchar(30));
select * from drivers;

create table customers(document varchar(25), id_no varchar(20), name varchar(20), gender varchar(25), country varchar(20), room_no varchar(20), checkin_time varchar(50), deposit varchar(20));
select * from customers;

create table department(department varchar(80), budget varchar(10));
insert into department values('Housekeeping','80000');
insert into department values('Kitchen and Food production','180000');
insert into department values('Drivers','90000');
insert into department values('Security','120000');
insert into department values('Managers','200000');

select * from department; 