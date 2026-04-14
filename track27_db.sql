drop table member_황희원;

create table member_황희원(
    id varchar2(5) not null primary key,
    name varchar2(10) not null,
    area varchar2(10),
    age number(3)

);


insert into member_황희원(id, name, area, age) values('201','황희원','대전',28);
rollback;
commit;