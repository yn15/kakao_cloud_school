/*
문제1: http://127.0.0.1:3000/hello?name=Jave Hello Jane !!!
문제2: http://127.0.0.1:3000/add?x=10&y=7 17
문제3: http://127.0.0.1:3000/gugu?dan=4 4단출력
문제3: http://127.0.0.1:3000/rect?width=5&height=7 사각형면접 35
*/

const http = require('http');
const url=require("url");
const fs = require("fs");
var server = http.createServer((req, res) => {
    var pathName = url.parse(req.url).pathname;
    if(pathName=="/"){
        res.statusCode=200;
        res.setHeader("Content-type", "text/html");
        res.end("<h1>question예아</h1>");
    }else if(pathName=="/hello"){
        question("hello", res, req);
    }else if(pathName=="/add"){
        question("add", res, req);
    }else if(pathName=="/gugu"){
        question("gugu", res, req);
    }else if(pathName=="/rect"){
        question("rect", res, req);
    }else{
        res.statusCode=200;
        res.setHeader("Content-type", "text/html");
        res.end("<h1>error</h1>");
    }
    
});

server.listen(3000, "127.0.0.1", ()=>{
    console.log("Server start at http://127.0.0.1:3000 ");
}); //3000번 포트를 열어라

function question(q, res, req){
    res.statusCode=200;
    res.setHeader("Content-type", "text/html");
    var query = url.parse(req.url, true).query;
    if(q=="hello"){
        name = query.name;
        res.end(`<h1>Hello ${name} !!!</h1>`);
    }else if(q=="add"){
        result = parseInt(query.x) + parseInt(query.y);
        res.end(`<h1>add ${result}</h1>`);
    }else if(q=="gugu"){
        num = parseInt(query.dan);
        result = ""
        for(i=1; i<=9; i++){
            result += `${num} * ${i} = ${num*i}<br/>`;
        }
        res.end(result);
    }else if(q=="rect"){
        w = parseInt(query.width);
        h = parseInt(query.height);
        res.end(`<h1>rect ${w*h}</h1>`)
    }
}
