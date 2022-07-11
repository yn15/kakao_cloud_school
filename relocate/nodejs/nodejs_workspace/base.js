const http = require('http'); //외부모듈을 이 파일로 불러온다
const url=require("url");
const fs = require("fs");
var server = http.createServer((req, res) => {
    var pathName = url.parse(req.url).pathname;
    res.statusCode=200;
    res.setHeader("Content-type", "text/html");
    res.end("<h1>Hello nodejs</h1>");
});


server.listen(3000, "127.0.0.1", ()=>{
    console.log("Server start at http://127.0.0.1:3000 ");
}); //3000번 포트를 열어라