create table student
(
    id varchar(255) not null,
    name varchar(255) not null,
    school_number varchar(255) not null,
    primary key(id)
);

insert into student
values('1','John Doe', 'e1234567');

insert into student
values('2','Jane Doe', 'a1234568');