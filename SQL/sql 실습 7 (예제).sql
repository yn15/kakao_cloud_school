-- 예제

use sqldb;

create table stdTbl (
	std_name varchar(10) not null primary key,
    std_addr varchar(4) not null
);

create table clubtbl (
	club_name varchar(10) not null primary key,
    club_room varchar(4) not null
);

create table stdclubtbl (
	num INT auto_increment primary key,
    std_name varchar(10) not null,
    club_name varchar(10) not null,
    foreign key (std_name) references stdtbl(std_name),
    foreign key (club_name) references clubtbl(club_name)
);

insert into stdtbl values ('김범수', '경남');
insert into stdtbl values ('성시경', '서울');
insert into stdtbl values ('조용필', '경기');
insert into stdtbl values ('은지원', '경북');
insert into stdtbl values ('바비킴', '서울');

insert into clubtbl values ('수영', '101호');
insert into clubtbl values ('바둑', '102호');
insert into clubtbl values ('축구', '103호');
insert into clubtbl values ('봉사', '104호');

insert into stdclubtbl values (NULL, '김범수', '바둑');
insert into stdclubtbl values (NULL, '김범수', '축구');
insert into stdclubtbl values (NULL, '조용필', '축구');
insert into stdclubtbl values (NULL, '은지원', '축구');
insert into stdclubtbl values (NULL, '은지원', '봉사');
insert into stdclubtbl values (NULL, '바비킴', '봉사');

-- 학생을 기준으로 학생이름, 지역, 가입한 동아리, 동아리방번호를 출력
select a.std_name, std_addr, b.club_name, club_room 
from stdtbl a Inner join stdclubtbl b ON a.std_name = b.std_name
inner join clubtbl c ON b.club_name = c.club_name order by a.std_name;

-- usertbl과 buytbl을 이용해서 다음을 구하라
-- 전체 회원의 구매기록을 조회 단, 구매 기록이 없는 회원도 출력
select u.userid, u.name, b.prodname, u.addr 
from usertbl u 
	left outer join buytbl b 
    on u.userid = b.userid
    order by u.userid;

-- 한번도 구매한 적이 없는 회원의 목록을 출력
select u.userid, u.name, b.prodname, u.addr 
from usertbl u 
	left outer join buytbl b 
    on u.userid = b.userid
    where b.prodname is null
    order by u.userid;