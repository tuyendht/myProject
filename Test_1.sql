use master
IF EXISTS (SELECT * FROM sys.databases WHERE name='Test_1')
	DROP DATABASE Test_1
Go
create database Test_1
go
use Test_1
go
create table Books
(
	bookID varchar(30) primary key,
	name varchar(50),
)
create table Registration
(
	username varchar(30),
	password varchar(20),
	lastname nvarchar(250),
	isAdmin bit
)
create table Orders
(
	orderID int identity(1,1) primary key,
	custName nvarchar(50),
	custAddress nvarchar(250)
)
create table OrdersDetail
(
	orderID int,
	bookID varchar(30),
	quantity int,
	CONSTRAINT oder_id FOREIGN KEY(orderID) REFERENCES Orders(orderID),
	CONSTRAINT book_id FOREIGN KEY(bookID) REFERENCES Books(bookID)
)
 

insert into Books values('E01','Harry Potter')
insert into Books values('E02','The Silence of the Lambs')
insert into Books values('E03','War and Peace')
insert into Books values('E04','Lolita')
insert into Books values('E05','The Adventures of Huckleberry Finn')


insert into Registration values('admin','1',N'Trung Tuyển',1)
insert into Registration values('user1','1',N'Minh Hiếu',0)
insert into Registration values('user2','1',N'Quang Thắng',0)
insert into Registration values('user3','1',N'Kim Loan',0)
insert into Registration values('user4','1',N'Minh Hiển',0)
insert into Registration values('user5','1',N'Tuấn Hoàng',0)
insert into Registration values('user6','1',N'Nguyễn Tuấn',0)

