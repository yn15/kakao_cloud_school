USE sqldb;

SELECT * FROM userTBL;
select * FROM buyTBL;

-- 이름이 김경호인 사람을 usertbl에서 추출
select * from usertbl where name = '김경호';

-- 1970년 이후에 출생하거나 신장이 182이상인 사람의 아이디와 이름을 조회하세요
select userID, name from usertbl where birthYear >= 1970 OR height >= 182;

-- 키가 180 ~ 183인 사람의 이름과 키를 조회
select name, height from usertbl WhERE height between 180 AND 183;

-- 지역이 강남, 전남, 경북인 사람의 이름과 지역 조회
select name, addr from usertbl WHERE addr IN ('강남', '전남', '경북');

-- 성이 김씨인 사람들의 이름과 키를 조회
select name, height from usertbl WHERE name LIKE '김%';

-- 김경호보다 키가 크거나 같은 사람의 이름과 키를 조회
select name, height from usertbl where height >= (select height from usertbl where name = '김경호');  

-- 지역이 '경남'인 사람의 키보다 키가 크거나 같은 사람 조회
select name, height from usertbl where height >= ANY (select height from usertbl where addr = '경남');

-- 먼저 가입한 순 조회
select name, mDate
from usertbl
order by mDate;

-- usertbl에서 회원들의 거주지역이 어디인지를 출력
select DISTINCT addr from usertbl limit 4;

select name, mDate from userTbl Order BY mDate ASC limit 1,2;

-- 테이블 복사
-- 데이터만 복사
-- 제약건 복사안된
CREATE TABLE buttbl2 (SELECT * FROM buytbl);

use sqldb;
-- 구매 테이블에서 사용자가 구매한 물품의 개수 조회
select userID, SUM(amount) from buytbl group by userID;

-- 구매테이블에서 각 사용자별 구매액의 총합을 출력하세요
select userID, SUM(amount*price) from buytbl group by userID;




