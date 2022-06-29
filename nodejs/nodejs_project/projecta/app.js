var createError = require('http-errors');
var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var logger = require('morgan');
//세션 처리 - express는 세션을 저장할 위치를 지정해야한다.
//파일도 가능하고 디비도 가능하다
//npm install express-session
//npm install session-file-store
const session = require('express-session');
const FileStore = require('session-file-store')(session);
//파일에 저장해보자

var indexRouter = require('./routes/index');
var usersRouter = require('./routes/users');
var boardRouter = require('./routes/board');
var memberRouter = require('./routes/member');
var app = express();

// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'ejs');

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false })); //body-parser가 express 내부에 들어감
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));
//세션 미들웨어 연결
app.use(session ({
  secret:'dfvgbjkhgfdesgrtjkjhfgdvgbmnkjhfgdergjkuijhfgrdthj', //암호화에 사용, 최대한 복잡하게
  resave:false,                                                //세션을 계속 저장하고 있을지 여부, 보통 false
  saveUninitialized:true,                                      //초기화 되지 않은채 스토어에 저장여부
  store:new FileStore()                                        //저장매체 - 여기서는 파일
}));

app.use('/', indexRouter);
app.use('/users', usersRouter);
app.use('/board', boardRouter);
app.use('/member', memberRouter);
// catch 404 and forward to error handler
app.use(function(req, res, next) {
  next(createError(404));
});

// error handler
app.use(function(err, req, res, next) {
  // set locals, only providing error in development
  res.locals.message = err.message;
  res.locals.error = req.app.get('env') === 'development' ? err : {};

  // render the error page
  res.status(err.status || 500);
  res.render('error');
});

module.exports = app;
