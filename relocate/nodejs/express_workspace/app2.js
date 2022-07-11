const { response } = require('express');
var express = require('express');
var app = express();

app.use("/", (req, res)=>{
    //브라우저 저보 확인
    console.log(req);
    var agent = req.header("User-Agent");
    console.log(agent);
    //match(/패턴/) - 정규식
    if(agent.toLowerCase().match(/chrome/) && !agent.toLowerCase().match(/edg/))
        res.send("agent is 크롬");
    else
        res.send("agent is not 크롬");
});

app.use((request, response) => {
    response.status(404).send(`<h1> Error </h1>`);
})

app.listen(4000, ()=>{
    console.log("server start http://127.0.0.1:4000");
})