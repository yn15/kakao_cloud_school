const http = require('http'); //외부 모듈을 이 파일로 불러온다
const fs = require("fs");
const url = require('url');
const querystring = require("querystring"); //현재는 폐기

var server = http.createServer((req, res) => {
    var pathName = url.parse(req.url).pathname;
    //http://localhost:3000?username=Tom&age=23

    if(req.method=="GET" && pathName=="/"){
        console.log(req);
        var query = url.parse(req.url, true).query; //쿼리를 파싱해서 JSON으로 수정
        console.log(query);
        console.log(query.username, query.age);

        var data = fs.readFileSync("./html/index.html", "utf-8");

        res.statusCode=200; 
        res.setHeader("Content-type", "text/html");
        res.end(data);
    }else if(req.method=="POST" && pathName=="/"){
        //폐기상황 
        // req.on("data", (data)=>{
        //     var result = querystring.parse(data.toString());
        //     console.log(result.username, result.age);
        //     res.statusCode=200; 
        //     res.setHeader("Content-type", "text/html");
        //     res.end("<h1>" + data + "</h1>");
        // })

        let body="";
        req.on("data", (data)=>{
            body += data;
        });

        req.on("end", ()=>{
            let postData = new URLSearchParams(body);
            console.log(postData);
            console.log(postData.get("username"), postData.get("age"));

            res.setHeader("Content-type", "text/html");
            res.end(`<h1>${postData.get("username")} ${postData.get("age")}</h1>`)
        })
    }
    
});

server.listen(3000, "127.0.0.1", ()=>{
    console.log("Server start at http://127.0.0.1:3000 ");
}); //3000번 포트를 열어라