var express = require('express');
var app = express();

app.use(express.urlencoded({extended:true})); 
//초창기에는 body-parser 모듈 설치후 사용했지만 현재는 express가 모두 처리한다

//특정 url - 어떤 action이 짝이 될 것인가 - 라우터
/*
클라이언트로부터 정보를 보낼 때
get : 127.0.0.1:4000/a?x=4&y=7 request.query["키"]
새로운 get방식 : 127.0.0.1:4000/a/4/7 request.params["키"]

post : 미들웨어를 하나 연결한다
app.use(express.urlencoded({extended:true}))  request.body["키"]
*/


app.get("/a", (req, res)=>{
    res.send("a입니다"); //writeHead + write + end   들어오는 데이터에 맞춰서 적절히 데이터를 전송한다
});

app.get("/b", (req, res)=>{
    res.send("b입니다");
})

app.get("/board/list", (req, res)=>{
    res.send("board입니다");
});

//새로운 get방식으로 값을 받아보자
app.get("/a/:x", (req, res)=>{
    var x = req.params.x;
    res.send("받은값은" + x + "입니다.");
});

//http://127.0.0.1:4000/a/4/5
app.get("/a/:x/:y", (req, res)=>{
    var x = req.params.x;
    var y = req.params.y;
    res.send(`받은값은 ${x} 와 ${y} 입니다.`);
});

//http://127.0.0.1:4000/add/4/5
app.get("/add/:x/:y", (req, res)=>{
    var x = parseInt(req.params.x);
    var y = parseInt(req.params.y);
    res.send(`${x} + ${y} = ${x+y}`);
});

//http://127.0.0.1:4000/person?name=Tom&age=11&phone=010-0000-0000
app.get("/person", (req, res)=>{
    var name = req.query.name;
    var age = req.query.age;
    var phone = req.query.phone;
    res.send(`이름 : ${name} 나이 :  ${age} 전화번호 : ${phone}`);
});

//http://127.0.0.1:4000/person/Tom/11/010-0000-1234
app.get("/person/:name/:age/:phone", (req, res)=>{
    var name = req.params.name;
    var age = req.params.age;
    var phone = req.params.phone;
    res.send(`이름 : ${name} 나이 :  ${age} 전화번호 : ${phone}`);
});

app.post("/person", (req, res)=>{
    var name = req.body.name;
    var age = req.body.age;
    var phone = req.body.phone;
    res.send(`이름 : ${name} 나이 :  ${age} 전화번호 : ${phone}`);
});


app.use((request, response) => {
    response.status(404).send(`<h1> Error </h1>`);
})

app.listen(4000, ()=>{
    console.log("server start http://127.0.0.1:4000");
})