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
module.exports = router;
