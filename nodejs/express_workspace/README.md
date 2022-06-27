# **express**
http객체보다 훨씬 사용이간편하고 기능도 많은 외부 모듈
- var express = require('express');
- var app = express();

- use함수는 get, post 모두에 응한다, 현재 모든 url을 혼자처리함

- res.send()는 send에 전해진 argument에 따라서 Content-type이 자동적으로 만들어짐

- res.end()는 보내줄 아무 데이터도 없는데 response를 끝내고 싶을 때 사용한다.

- express --view=ejs 프로젝트명
  - 기본적인 웹프로젝트를 빌드해준다