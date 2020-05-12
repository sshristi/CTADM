SET FOREIGN_KEY_CHECKS = 0;
drop table if exists customer;
drop table if exists movie;
drop table if exists rating;
SET FOREIGN_KEY_CHECKS = 1;
 
 create table movie(
 mId integer AUTO_INCREMENT,
 name varchar(20),
 PRIMARY KEY(mId)
 );

 create table customer(
 cId INT PRIMARY KEY auto_increment,
 mId INT,
 fname varchar(15),
 lname varchar(15),
 constraint mov_fk foreign key (mId) references movie(mId)
 );

 create table rating(
rId INT AUTO_INCREMENT PRIMARY KEY,
cId INT,
rating FLOAT,
constraint cus_fk foreign key (cId) references customer(cId)
);

 
 insert into movie values (null,'avengers');
 insert into movie values (null, 'high on life');
 insert into movie values (null, 'extraction');
 insert into movie values (null, 'money heist');
 
 insert into customer values (null, 1, "raj", "mohan");
 insert into customer values (null, 2, "aku", "singh");
 insert into customer values (null, 2, "shristi", "singh");
 
 insert into rating values (null,1,3.1);
 insert into rating values (null,2, 4.5);
 insert into rating values (null,2, 5);
 insert into rating values (null,3, 2.3);
 
 select * from movie;
 select * from customer;
 select * from rating;
