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




insert into member_황희원 (id,name,area,age) values ('303','이미자','서울',29);
rollback;



select count(*) from student_황희원 where syear = '1' and sclass='1' and sno= '1';


update student_황희원 set name='홍길동' where syear ='1' and 
sclass = '1' and sno='1';

delete from student_황희원 where syear = '1' and sclass = '1' and sno='1';


create table animal_황희원 (
no varchar2(3) not null primary key,
name varchar2(30) not null,
kind varchar2(1) not null ,
weight number(4) not null 
);

--카인드 해상동물 육상동물 해상O 육상L  kind 보여줄때는 해상 육상으로 보여준다

select count(*) from animal_황희원 where no='201';

insert into animal_황희원 (no,name,kind,weight) values ('1','1','1',1);
rollback;
update animal_황희원 set name='연개길동',kind='o',weight=68 where no = '101';

create table snack_황희원(
pcode varchar2(4) not null primary key,    --제품코드 p001 p002
pname varchar2(30) not null,   --새우깡
company varchar2(2) not null,    --제조사코드,10,20
price number(5) not null,
makedate date not null,  --제조일자
foreign key(company) REFERENCES snack_company(company_code)
);

select count(*) from snack_황희원 where pcode='p001';
insert into snack_황희원(pcode,pname,company, price,makedate) 
values ('p004','초코파이','50',1450,'2026-04-20');
select * from snack_company;
select s.pcode,s.pname,s.company,c.company_name,s.price,to_char(s.makedate,'yyyy-MM-dd') as makedate 
from snack_황희원 s,snack_company c 
where s.company = c.company_code;
drop TABLE snack_황희원;
select s.pcode,s.pname,s.company,c.company_name,s.price,to_char(s.makedate,'yyyy-MM-dd') as makedate from snack_황희원 s,snack_company c where s.company = c.company_code;
insert into snack_황희원(pcode,pname,company, price,makedate) 
				values ('p006','고구마깡','40',1500,'2026-04-20');
delete from snack_황희원 where pcode='p001';
                
update snack_황희원 set pname='',company='',price where pcode='';