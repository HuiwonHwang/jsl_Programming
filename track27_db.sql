--테이블 삭제
drop table member_황희원;

--테이블 생성
create table member_황희원(
    id varchar2(5) not null primary key,
    name varchar2(30) not null,
    area varchar2(10),
    age number(3)
);

--삭제
delete from member_황희원 where name ='홍길동';
--조회
select id,name from member_황희원 where name like '%동%';
select * from member_황희원 order by id desc;
select id,name from member_황희원 where id = '101';
--수정
update member_황희원 set name='연개길동',area='부산',age=68 where id = '201';
--행 삽입
insert into member_황희원 values('601','차길동');
insert into member_황희원(id,name,area)values('501','상길동');
insert into member_황희원(id, name, area, age) values('601','제갈길동','일본',34);

rollback;
commit;

select count(*) as count from member_황희원 where id = '101';



create table student_황희원 (
syear varchar2(1) not null,
sclass varchar2(2) not null , 
sno varchar2(2) not null ,
name varchar2(21) not null,
kor number(3) not null,
eng number(3) not null,
mat number(3) not null,
primary key(syear,sclass,sno)
);

insert into student_황희원(syear, sclass, sno, name,kor,eng,mat) 
values('1','2','3','황희원',90,90,90);

select * from student_황희원 where syear='1' and sclass='1' and sno ='1'; 
















