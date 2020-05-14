SET FOREIGN_KEY_CHECKS = 0;

drop table if exists rating;
drop table if exists customer;
drop table if exists movie;

SET FOREIGN_KEY_CHECKS = 1;

create table movie(
m_id integer AUTO_INCREMENT,
 name varchar(20),
 PRIMARY KEY(m_id));
 
 create table customer(
 c_id INT auto_increment,
 firstname varchar(20),
 lastname varchar(20),
 PRIMARY KEY(c_id)
 );
 
 create table rating(
id INT AUTO_INCREMENT PRIMARY KEY,
c_id INT,
m_id INT,
rate FLOAT
);

 ALTER TABLE rating ADD FOREIGN KEY (m_id) REFERENCES movie(m_id);
ALTER TABLE rating ADD FOREIGN KEY (c_id) REFERENCES customer(c_id);

 insert into movie values (null,'avengers');
 insert into movie values (null, 'high on life');
 insert into movie values (null, 'extraction');
 insert into movie values (null, 'money heist');
 insert into movie values (null, 'URI');
 insert into customer values (null, "Luna", "Longbottom");
 insert into customer values (null, "harry", "Potter");
 insert into customer values (null, "snape", "guru");
 insert into customer values (null, "Hagrid", "Spider");
 insert into customer values (null, "Cedrig", "degree");
 insert into customer values (null, "tom", "Riddle");
 insert into rating values (null, 1, 2, 3.0);
  insert into rating values (null, 1, 3, 4.3);
   insert into rating values (null, 1, 5, 2.6);
    insert into rating values (null, 1, 1, 1.7);
     insert into rating values (null, 2, 1, 4);
      insert into rating values (null, 2, 5, 5);
       insert into rating values (null, 2, 2, 5);
        insert into rating values (null, 4, 2, 2);
         insert into rating values (null, 2, 2, 2.5);
          insert into rating values (null, 3, 2, 3);
           insert into rating values (null, 6, 2, 3);
            insert into rating values (null, 5, 2, 3);
 
 
 
select * from movie;
select * from customer;
select * from rating;