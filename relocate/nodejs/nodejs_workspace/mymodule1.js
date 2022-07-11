function abs(number){
    if(number>0)
        return number;
    else
        return -number;
}

function isLeap(s){
    if(s%4==0 && s%100!=0 || s%400==0)
        return true;
    else
        return false;
}

function hello(){
    return "Hello nodejs";
}

//외부로 모듈을 노출시켜야 다른 모듈에서 이 모듈에 대한 접근이 가능하다
exports["abs"] = abs;
exports["isLeap"] = isLeap;
//module.exports = hello;
