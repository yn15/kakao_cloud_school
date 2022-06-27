const http = require('http');
const url=require("url");
const fs = require("fs");
var server = http.createServer((req, res) => {
    var pathName = url.parse(req.url).pathname;

    if(pathName=="/image"){
        fs.readFile("./images/salad.jpg", (error, data)=>{
            if(error){
                res.statusCode=200;
                res.setHeader("Content-type", "text/html");
                res.end("<h1>file not found</h1>");
                return;
            }

            res.writeHead(200, {'Content-Type' : 'image/jpeg'});
            res.end(data);
        })
    }

    if(pathName=="/movie"){
        fs.readFile("./medias/salad.mp4", (error, data)=>{
            if(error){
                res.statusCode=200;
                res.setHeader("Content-type", "text/html");
                res.end("<h1>file not found</h1>");
                return;
            }

            res.writeHead(200, {'Content-Type' : 'video/mp4'});
            res.end(data);
        })
    }
    
});


server.listen(3000, "127.0.0.1", ()=>{
    console.log("Server start at http://127.0.0.1:3000 ");
}); //3000번 포트를 열어라