var mongoose = require("mongoose");


var promise = mongoose.connect('mongodb://127.0.0.1/mydb');
var db = mongoose.connection;

//mongoDB에서 오는 오류가 있으면 오루를 콘솔로 바인딩하라
db.once('error', console.error.bind(console, 'connection error:'));
db.once('open', ()=>{
    console.log("연결성공"); 
    doRead();
    //doView("홍길동");
    doInsert("이정우", 43);
    doInsert("김성훈", 32);
});

function doRead(){
    db.collection("person").find({}).toArray((err, results)=>{
        if(err) throw err;
        console.log(results);
    })
}

function doView(name){
    db.collection("person").find({name:name}).toArray((err, results)=>{
        if(err){
            console.log(err);
        }
        console.log(results);
    })
}

function doInsert(name, age){
    db.collection("customSequence").findOneAndUpdate(
        {"_id":"hero"},
        {$inc:{seq:1}},
        function(err, doc){
            console.log(doc);
            console.log(doc.value.seq);
            var person={name:name, age:age, id:doc.value.seq}
            db.collection("person").insertOne(person, (err, res)=>{
                console.log("insert success");
            })
        }
    )
}

