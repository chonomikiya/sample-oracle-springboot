create table mydata(
    id integer generated always as identity not null primary key,
    name varchar(30) not null,
    price number(12,0) not null
);
insert into mydata(name,price)values('akebi',100);
insert into mydata(name,price)values('aserora',200);
insert into mydata(name,price)values('abokado',300);
insert into mydata(name,price)values('anzu',400);
insert into mydata(name,price)values('itigo',500);
insert into mydata(name,price)values('itiziku',600);
insert into mydata(name,price)values('ume',700);
insert into mydata(name,price)values('unsyuumikan',800);
insert into mydata(name,price)values('orenzi',900);
insert into mydata(name,price)values('kaki',1000);