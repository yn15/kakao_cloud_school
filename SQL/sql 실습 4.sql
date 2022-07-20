USE sqldb;

CREATE TABLE testtbl1 (
	id  INT,
    username CHAR(3),
    age INT
);

INSERT INTO testtbl1 VALUES(1, '홍길동', 25);

INSERT INTO tESTTbl1(id, uSerName) VALUES(2, '이순신');
INSERT INTO TESTTBl1(USerName, iD) VALUES('강감찬', 3);

CREATE TAblE TEsttBL2 (
	ID INT auto_incRement PRiMARY KEY,
    uSERNAME CHAR(3),
    age INT
);

insert into testtbl2 values(null, '홍길동', 25);
insert into testtbl2 values(null, '김길동', 30);

alter table testtbl2 auto_increment = 100;

insert into testtbl2 values(null, '최길동', 50);

set @@auto_increment_increment = 5;

insert into testtbl2 values(null, '박길동', 60);
insert into testtbl2 values(null, '백길동', 680);

create table testtbl3 (
	id INT,
    fname varchar(50),
    lname varchar(50)
);

insert into testtbl3
	select emp_no, first_name, last_name from employees.employees;
    
select * from testtbl3;

start transaction;

update testtbl3
set lname = '없음'
where fname = 'Kyoichi';

select * from testtbl3 where fname='Kyoichi';

delete
from testtbl3
where fname = 'Kyoichi'
limit 100;

rollback;

-- MySQL이 제공하는 문자열 함수
SELECT char_length('abcde'), char_length('홍길동'), length('abcde'), length('홍길동');

select concat('소리없는', '아우성'), CONCAT_WS('-', '2022', '02', '20');

select format(123456.1415234, 3);

select trim('           소리없는 아우성                ');

select replace('이것은 소리 없는 아우성', '소리', '양심');

select substring('이것은 소리없는 아우성', 3, 5);

select curdate(), now(), year(curdate())

