use sqldb;

-- 전체 구매자가 구매한 물품 개수의 평균은 얼마인가요?
select AVG(amount) FROM buytbl;

-- 각 사용자별로 한번 구매시 물건을 평균 몇 개 구했는지 조회
select userID, AVG(amount) `평균 구매 개수` FROM buytbl group by userID;

-- 가장 큰ㄴ 키와 가장 작은 키의 회원 이름과 키를 조회 usertbl
select name, height from usertbl where height IN ( (Select max(height) from usertbl), (select min(height) from usertbl));

-- 사용자별 총 구매금액이 1,000 이상인 사용자만 조회
select userID, SUM(price*amount) from buytbl group by userID having SUM(price*AMOUNT) >= 1000;