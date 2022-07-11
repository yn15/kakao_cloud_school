var express = require('express');
var app = express();

app.use("/use", (request, response) => {
    response.writeHead(200, {"Content-Type": "text/html"});
    response.end(`<h1>df Test</h1>`);
})

app.get("/data", (req, res) => {
    res.send({name:"홍길동", age:12, phone:"010-0000-0000"});
})

app.get("/msg", (req, res) => {
    res.send("<h1>안녕하세요 express 입니다.</h1>");
})

app.get("/test", (request, response) => {
    response.writeHead(200, {"Content-Type": "text/html"});
    response.end(`<h1>GET Test</h1>`);
})

app.post("/test", (request, response) => {
    response.writeHead(200, {"Content-Type": "text/html"});
    response.end(`<h1>POST Test</h1>`);
})

app.use((request, response) => {
    response.status(404).send(`<h1> Error </h1>`);
})


app.listen(4000, ()=>{
    console.log("server start http://127.0.0.1:4000");
})