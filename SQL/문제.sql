-- 문제 9개
-- study.sql
-- word파일에 있는 문제 9개 해결

use sqldb;
-- 1. 30번 부서의 직무 별 급여의 평균을 파악하고자 합니다.
--    출력 컬럼 명: "직무", "급여 평균"    
--    연봉의 평균은 백 단위 까지만 나타냅니다.

select job '직무', truncate(avg(sal), -2) '급여 평균' from emp where deptno = 30 group by job;

-- 2. 근무 중인 직원이 4명 이상인 부서의 정보를 출력합니다.
--  출력 컬럼 명: "부서명", "직원 수"

select dname '부서명', count(*) '직원 수' from emp e 
inner join dept d on e.deptno = d.deptno 
group by d.dname having count(*) >=4;

-- 3. 직무 별(job) 급여의 합을 출력하고 마지막에 누적 집계도 출력합니다. 
-- 누적 집계를 출력하는 행의 급여의 합은 총합계를 출력합니다.
--    또한 금액에는 천단위마다 콤마(,)를 출력합니다.
--    출력 컬럼 명: "직무명", "급여의 합"
select ifnull(job, 'TOTAL') '직무 명', format(sum(sal), 0) '급여의 합' from emp group by job with rollup;

-- 4. 이 회사에서 월급을 제일 많이 받는 사람의 이름과 월급 그리고 급여 등급을 출력하세요.
--    출력 컬럼 명:  "직원명", "급여", "급여 등급"

select ename '직원명', sal '급여', s.grade '급여 등급' from emp e, salgrade s
where sal = (select max(sal) from emp) AND e.sal between s.losal and s.hisal; 

-- 5. 1981년에 입사한 직원들의 이름을 월급을 많이 받는 순으로 출력합니다. 
-- 급여는 sal + comm으로 계산하는데 comm 이 null인 경우에는 0으로 계산합니다. 
-- 또한 천 단위마다 ,를 붙이고 뒤에 '원' 을 붙여서  출력합니다. 
-- 출력 컬럼 명: "직원명", "급여"

select ename '직원명', CONCAT(format(sal+ifnull(comm, 0),0), '원') '급여' 
from emp where year(hiredate) = '1981' 
order by sal+ifnull(comm,0) DESC;


-- 6. 입사한 년도가 1980년이면 'A'를 1981년이면 'B'를 1982년이면 'C'를 1983년이면 'D'로 그룹을 출력합니다.
--     출력 컬럼 명: "직원명", "입사년월일", "그룹"
--     입사년월일은 'XXXX년 XX월 XX일'로 표현합니다.

select ename '직원명', DATE_FORMAT(hiredate, '%Y년 %m월 %d일') '입사년월일',
CASE
	WHEN ( year(hiredate) = '1980') THEN 'A'
    WHEN ( year(hiredate) = '1981') THEN 'B'
    WHEN ( year(hiredate) = '1982') THEN 'C'
    ELSE 'D'
END AS '그룹'
from emp;

-- 7. 사원번호와 사원이름, 그리고 그 사원을 관리하는 관리자의 사원번호와 사원이름을 출력하되 
-- 각각의 컬럼명을 "사원 사번", "사원 이름", "관리자 사번", "관리자 이름"으로 출력하는데 관리자가 없는 직원은 제외합니다.
select a.empno '사원 사번', a.ename '사원 이름', b.empno '관리자 사번', b.ename '관리자 이름' 
from emp a inner join emp b on a.mgr = b.empno;

-- 8. 'CHICAGO' 라는 도시에서 근무중인 직원의 사번, 성명 그리고 부서번호를 출력합니다.(JOIN 구문으로 해결)

select empno, ename, c.deptno from locations a inner join dept b ON a.loc_code = b.loc_code
inner join emp c on c.deptno = b.deptno where a.city = 'CHICAGO';

-- 9. 30번 부서의 직원들의 급여보다 많은 급여를 받는 직원들의 이름을 출력합니다.
select ename, sal from emp where sal > ALL ( select sal from emp where deptno = 30);