const http = require('http');
const url=require("url");
const fs = require("fs");
var server = http.createServer((req, res) => {
    var pathName = url.parse(req.url).pathname;
    //url에 따라서 다르게 동작하는걸 라우팅한다고 한다
    if(pathName=="/"){
        res.statusCode=200;
        res.setHeader("Content-type", "text/html");
        res.end("<h1>Hello nodejs</h1>");
    }else if(pathName=="/test"){
        res.statusCode=200;
        res.setHeader("Content-type", "text/html");
        res.end("<h1>Test</h1>");
    }else{
        res.statusCode=200;
        res.setHeader("Content-type", "text/html");
        res.end("<h1>error</h1>");
    }
    
});


server.listen(3000, "127.0.0.1", ()=>{
    console.log("Server start at http://127.0.0.1:3000 ");
}); //3000번 포트를 열어라

/*
문제1: http://127.0.0.1:3000/hello?name=Jave Hello Jane !!!
문제2: http://127.0.0.1:3000/hello?add?x=10&y=7 17
문제3: http://127.0.0.1:3000/hello?gugu?dan=4 4단출력
문제3: http://127.0.0.1:3000/hello?rect?width=5&height=7 사각형면접 35
*/
