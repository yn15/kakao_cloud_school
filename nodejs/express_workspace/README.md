# **express**
http객체보다 훨씬 사용이간편하고 기능도 많은 외부 모듈
- var express = require('express');
- var app = express();

- use함수는 get, post 모두에 응한다, 현재 모든 url을 혼자처리함

- res.send()는 send에 전해진 argument에 따라서 Content-type이 자동적으로 만들어짐

- res.end()는 보내줄 아무 데이터도 없는데 response를 끝내고 싶을 때 사용한다.

- express --view=ejs 프로젝트명
  - 기본적인 웹프로젝트를 빌드해준다

------
<br>

# **DBMS**
 - **오라클**
   - 테라바이트 이상의 데이터 처리 가능, 빅데이터 처리 가능
   - 사용하는 기간내내 비용 지불
   - 상업적 서비스를 실행하기 전까지는 오라클 정식 버전을 사용해도 불법 아니다.
   - 익스프레스 버전은 정식 오라클버전의 맛 보기인데 튜닝쪽 가지 않는 이상 지장없다.
   - 정식버전도 30~40분 이내에 설치가능

 - **MySQL**
   - 무료였으나 회사가 오라클사에 인수됨, 오라클사에 라이센스가 있다.
   - community 버전을 다운 받아 설치해서 사용하고, MySQL Workbench 그래픽을 지원하는 클라이언트 프로그램
   - 상업적 서비스를 시작하면서 돈을 내야 한다
   - 비주얼 도구 제공, 쿼리 만들기 쉬움

 - MariaoDB
   - 예전에 MySQL만들던 사람끼리 모여서 MariaDB를 만듦
   - 현재까지 무료배포
   - 쿼리나 내부함수가 오라클보다 쉬움
   - 하지만 데이터가 많아지면 속도가 현저히 **저하**됨
 - DBMS 제어 툴 
   - sqlgate(오라클, mssql, mysql) - 개인용 freeware를 가진다
   - heidsql - mysql용 그래픽툴(맥북버젼 지원 안함), 무료, mysql만 가능
   - phpmyadmin 
     - 웹사이트로 mariadb를 접근하게 해줌
     - 보통 호스팅 업체들이 제일 많이 사용
   - xampp 프로그램
     - 아파치서버, php서버, 톸맷, mysql, phpmyadmin 한번에 설치