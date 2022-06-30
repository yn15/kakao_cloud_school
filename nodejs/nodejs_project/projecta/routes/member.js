var express = require('express');
var router = express.Router();
var common = require('./common');
/* GET home page. */
router.get('/ss', function(req, res, next) {
  req.session["userid"]="test";
  req.session["username"]="Tom";
  req.session.save(()=>{
    console.log("세션 저장")
    res.redirect("/member/get");
  })
  
});

router.get('/get', function(req, res, next) {
    res.send(`${req.session["userid"]} ${req.session["username"]}`);
});

router.get('/logon', (req,res)=>{
  res.render("./member/member_logon");
});

router.post("/logon", (req, res)=>{
  var userid = req.body.userid;
  var password = req.body.password;
  var sql = "select userid, password, username, email from member where userid = '" + userid + "'";
  common.excuteDB(sql)
  .then((result)=>{
    if(result.length == 0)
      res.send({"result":"3"}); //아이디 존재 안함
    else{
      if(result[0]["password"]==password){
        //로그온 세션에 저장하자
        req.session['userid']=result[0]["userid"];
        req.session['username']=result[0]["username"];
        req.session['email']=result[0]["email"];

        res.send({"result":"1"}); //로그온 성공
      }else{
        res.send({"result":"2"}); //패스워드 실패
      }
    }
  })
})

router.get("/logout", (req, res)=>{
  req.session.destroy();
  res.redirect("/");
})

router.get("/register", (req, res)=>{
  res.render("./member/member_register");
})

router.post("/register", (req, res)=>{
  var userid = req.body.userid;
  var password = req.body.password;
  var username = req.body.username;
  var email = req.body.email;
  var phone = req.body.phone;

  let sql = `insert into member(userid, password, username, email, phone, wdate)
              values(?, ?, ?, ?, ?, now())`;
  var params =[userid, password, username, email, phone];
  common.excuteDB(sql, params)
  .then((result)=>{
    res.send({result:"success"});
  })
  .catch((error)=>{
    console.log(error);
    res.send({result:"fail"});
  })
})

router.post("/duplicate", (req,res)=>{
  var userid = req.body.userid;
  var sql = `select count(*) cnt from member where userid='${userid}'`;
  common.excuteDB(sql)
  .then((result)=>{
    if(result[0]["cnt"]==0){
      res.send({result:"success"});
    }else{
      res.send({result:"fail"});
    }
  })
})

module.exports = router;
