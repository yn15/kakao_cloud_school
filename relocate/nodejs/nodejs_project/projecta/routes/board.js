var express = require('express');
var router = express.Router();
var mysql = require("mysql");
var common = require("./common");
// var pool = mysql.createPool({
//   connectionLimit:10,
//   host:"127.0.0.1",
//   user:"root",
//   password:"1234",
//   database:"mydb",
//   port:3306
// });
/* GET home page. */
router.get('/', function(req, res, next) {
  res.redirect('/board/list');
});

router.get("/list", (req, res) => {
  sql = `select a.id, a.writer, a.title, a.contents, a.hit,
  date_format(a.wdate, '%Y-%m-%d') as wdate from board a`;
  common.excuteDB(sql, [])
  .then((rows)=>{
    res.render('./board/board_list.ejs', {data:rows});
  });
  
  // pool.getConnection((error, connection)=>{
  //   if(error){
  //     console.log(err);
  //     return;
  //   }
  //   console.log("연결 성공");

  //   sql = `select a.id, a.writer, a.title, a.contents, a.hit,
  //   date_format(a.wdate, '%Y-%m-%d') as wdate from board a`;

  //   connection.query(sql, (err, rows)=>{
  //     if(err){
  //         console.log(err);
  //     }
  //     const data = rows;
  //     res.render("./board/board_list.ejs", {data:data});
  //     connection.release();
  //   });
  // })
});

router.get("/view/:id", (req, res) => {
  var id = parseInt(req.params.id);

  sql = `update board set hit=hit+1 where id='${id}'`
  common.excuteDB(sql, [])
  .then((rows)=>{
    sql = `select a.id, a.writer, a.title, a.contents, a.hit,
              date_format(a.wdate, '%Y-%m-%d') as wdate from board a where a.id='${id}'`;
    common.excuteDB(sql, [])
    .then((rows)=>{
      res.render('./board/board_view.ejs', {id_data:rows[0]});
    });
  });

      
  // pool.getConnection((error, connection)=>{
  //   if(error){
  //     console.log(err);
  //     return;
  //   }
  //   console.log("연결 성공");

  //   sql = `update board set hit=hit+1 where id='${id}'`;
  //   connection.query(sql, (err, rows)=>{
  //     sql2 = `select a.id, a.writer, a.title, a.contents, a.hit,
  //      date_format(a.wdate, '%Y-%m-%d') as wdate from board a where a.id='${id}'`;
  //     connection.query(sql2, (err, rows)=>{
  //       if(err){
  //           console.log(err);
  //       }
  //       const data = rows;
  //       res.render("./board/board_view.ejs", {id_data:data[0]});
  //     });
  //     if(err){
  //         console.log(err);
  //     }
  //     connection.release();
  //   });
  // })
})


router.get("/write", (req, res) => {
  res.render("./board/board_write.ejs");
});

router.post("/save", (req, res) =>{
  var title = req.body.title;
  var writer = req.body.writer;
  var contents = req.body.contents;

  let sql = `insert into board(title, contents, writer, wdate, hit)
              values('${title}', '${contents}', '${writer}', now(), 0)`;
  common.excuteDB(sql, [])
  .then((rows)=>{
    res.redirect("/board/list");
  });
  // pool.getConnection((error, connection)=>{
  //   if(error){
  //     console.log(err);
  //     return;
  //   }
  //   console.log("연결 성공");

    // let sql = `insert into board(title, contents, writer, wdate, hit)
    //               values('${title}', '${contents}', '${writer}', now(), 0)`;

  //   connection.query(sql, (err, rows)=>{
  //     if(err){
  //         console.log(err);
  //     }
  //     res.redirect('/board/list');
  //     connection.release();
  //   });
  // });
})

router.get("/delete/:id", (req, res) =>{
  var id = parseInt(req.params.id);
  let sql = `delete from board where id='${id}'`;
  common.excuteDB(sql, [])
  .then((rows)=>{
    res.redirect("/board/list");
  });
  // pool.getConnection((error, connection)=>{
  //   if(error){
  //     console.log(err);
  //     return;
  //   }

  //   let sql = `delete from board where id='${id}'`;

  //   connection.query(sql, (err, rows)=>{
  //     if(err){
  //         console.log(err);
  //     }
  //     console.log(sql);
  //     res.redirect('/board/list');
  //     connection.release();
  //   });
  // });
})

module.exports = router;

