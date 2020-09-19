create table res(
res_no number primary key,
res_name varchar2(50),
res_content varchar2(1000),
res_date date,
res_tel varchar2(30),
res_si varchar2(100),
res_gu varchar2(100)
);

create sequence res_seq
increment by 1
start with 1;

create table res_pic(
res_pic_no number primary key,
res_pic_name varchar2(150),
res_no number
);

create sequence res_pic_seq
increment by 1
start with 1;