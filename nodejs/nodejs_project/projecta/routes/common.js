var mysql = require("mysql");

var pool = mysql.createPool({
  connectionLimit:10,
  host:"127.0.0.1",
  user:"root",
  password:"1234",
  database:"mydb",
  port:3306
});

async function excuteDB(sql, params){
    let promise  = new Promise((resolve, reject)=>{
        pool.getConnection((err, conn) => {
            conn.query(sql, params, (err,rows)=>{
                if(err)
                    reject(err);
                else
                    resolve(rows);
                conn.release();
            });
        });
        
    });
    return promise;
    await promise;
};

exports.pool = pool;
exports.excuteDB = excuteDB;