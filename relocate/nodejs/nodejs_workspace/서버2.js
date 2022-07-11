const http = require('http'); //외부 모듈을 이 파일로 불러온다
const fs = require("fs");
const url = require('url');

var server = http.createServer((req, res) => {
    var pathName = url.parse(req.url).pathname;
    //http://localhost:3000?name=Tom&age=23

    if(req.method=="GET" && pathName=="/"){
        //console.log(req);
        var query = url.parse(req.url, true).query; //쿼리를 파싱해서 JSON으로 수정
        console.log(query);
        console.log(query.name, query.age);
        console.log("getgegtget")
        var data = fs.readFileSync("./html/index.html", "utf-8");
        
        res.statusCode=200; 
        res.setHeader("Content-type", "text/html");
        res.end(data);
    }else if(req.method=="POST" && pathName=="/"){
        req.on("data", (data)=>{

            res.statusCode=200; 
            res.setHeader("Content-type", "text/html; charset=utf-8");
            
            res.end("<h1>" + data + "</h1>");
        })
    }
    
});

server.listen(3000, "127.0.0.1", ()=>{
    console.log("Server start at http://127.0.0.1:3000 ");
}); //3000번 포트를 열어라