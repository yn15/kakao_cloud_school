use sqldb;

-- 구매 테이블에서 'JYP'라는 아이디를 가진 사람이 구매한 물건을 발송하기 위해서 이름과 주소가 필요해요
-- 발송하기 위해서 이름과 주소가 필요, 이 정보는 usertbl에 존재
-- 두 테이블을 결합해서 결과를 알아야함

select a.userID, name, addr from buytbl a inner join usertbl b ON a.userID = b.userID where a.userID='JYP';

select a.userID, name, addr
from buytbl a, usertbl b
where a.userid = b.userid;