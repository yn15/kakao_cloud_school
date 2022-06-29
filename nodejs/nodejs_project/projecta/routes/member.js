var express = require('express');
var router = express.Router();

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

module.exports = router;
