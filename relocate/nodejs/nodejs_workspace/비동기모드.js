var fs = require("fs");
//try..catch로 예외를 처리할 수 없음

fs.readFile("./mymodule1.js", "utf-8", (error, data)=>{
    if(error){ //에러가 있을 때 객체가 만들어져서 전달됨
        console.log(error);
        return;
    }
    console.log(data);
})
    


console.log("종료............................................................................................................");