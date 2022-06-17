let json = "{bad json}";

try{
    let user = JSON.parse(json);
    alsert(user.name);
}catch (e) {
    console.log("데이터에 에러가 있어 재요청을 시도합니다.");
    console.log(e.name);
    console.log(e.message);
}finally{
    console.log("에러가 발생하던 말던 여기는 반드시 거친다");
}