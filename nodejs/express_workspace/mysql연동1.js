//mysql, promise 기반의 mySQL(콜백의 지옥을 벗어나기 위해서)
//mysql - 트랜잭션 처리할 때 콜백의 지옥에 빠짐
//npm install mysql

var mysql = require('mysql');

var pool = mysql.createPool({
    connectionLimit:10,
    host:'localhost', //DB IP
    user:'root',
    password:'1234',
    database:'mydb',
    port:3306
});

var title = "제목6";
var writer = "이상";
var contents = "내용6";

//데이터 추가하기
//sql2 =`insert into board(title, writer, contents, wdate, hit) values('${title}', '${writer}', '${contents}', now(), 0)`;
// sql2 = "insert into board(title, writer, contents, wdate, hit) values(?, ?, ?, now(), 0)";
// params = ["제목6", "이상", "내용6"];
// console.log(sql2);

// pool.getConnection((err, connection)=>{
//     connection.query(sql2, (err, rows)=>{
//         if(err){
//             console.log(err);
//         }
//         connection.release();
//     });
// })


pool.getConnection((error, connection)=>{
    if(error){
        console.log(err);
        return;
    }
    console.log("연결 성공");

    sql2 = "insert into board(title, writer, contents, wdate, hit) values(?, ?, ?, now(), 0)";
    params = ["제목6", "이상", "내용6"];

    connection.query(sql2, params, (err, rows)=>{
        if(err){
            console.log(err);
        }
        // connection.release();
    });

    sql = `select a.id, a.writer, a.title, a.contents,
    date_format(a.wdate, '%Y-%m-%d') as wdate from board a`;
    connection.query(sql, (err, rows)=>{
        //쿼리가 실행된 결과를 가져온다
        if(err){
            console.log(err);
            return;
        }
        //rows 파라미터에 수행된 결과가 전달된다.
        for(let row of rows){
            console.log(row);
        }
        connection.release(); //연결해제
    })
});




//mysql8이상부터가
//alter user 'root'@'localhost' identified with mysql_native_password by '1234';