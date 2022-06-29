var express = require('express');
var router = express.Router();
var mysql = require("mysql");
var pool = mysql.createPool({
  connectionLimit:10,
  host:"127.0.0.1",
  user:"root",
  password:"1234",
  database:"mydb",
  port:3306
});

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('./board/board_list');
});

module.exports = router;
