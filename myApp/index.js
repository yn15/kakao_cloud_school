/*
variable hoisting
 console.log(score);  //undefined
 var score;
 ------------------------------------------------
 var x = 1;
 var y = 2;
 var keyword로 변수의 중복선언이 가능
 var x = 100;  // 가능, var keyword가 없는 것처럼 동작
 var y;        // 가능, 초기화 구문이 없으면 무시
 ------------------------------------------------ 
*/

/*
var x = 1; //전역 변수
if(true){
    var x = 100;
}
console.log(x); //100
var i = 100;
for(var i=0; i<5; i++){
    console.log(i); //1 2 3 4 5
}
console.log(i); // 5
//------------------------------------------------
*/

/*
var x = 1;
function myFunc(){
    console.log(x); //100
    var x = 100; //function-level scope
    //함수 내부에서도 hoisting 발생
}
console.log(x); // 1
myFunc();
-----------------------------------------------
*/

/*
let score = 100;
{
    let score = 10;
    let myVar = 1;
}
console.log(myVar);
----------------------------------------
*/

/*
console.log(myVar);
let myVar = 100;
------------------------------
*/

/*
let myVar = 1; //global variable
{
    console.log(myVar);
    let myVar = 100;
}
//메모리에 할당만되고 사용할 수 없는 상태 - 일시적인 데드존 -> 정의가 되어야함
---------------------------------------
*/

/*
let myVar = 1.0;
console.log(myVar === 1);
// == 값이 같냐 === 타입과 값이 같냐
console.log(3/2);
*/

/*
let str = '이것은 \n소리없는 \n아우성';
console.log(str);
let str1 = `이것은
소리없는
아우성`;
console.log(str1);
*/

/*
let name1 = '홍길동';
console.log('내 이름은 ' + name1 + '입니다.');
console.log(`내 이름은 ${name1} 입니다`);
*/

/*
const mySymbol = Symbol();
console.log(typeof(mySymbol)); //symbol
console.log(mySymbol);
const mySymbol1 = Symbol('소리 없는 아우성');
const mySymbol2 = Symbol('소리 없는 아우성');
console.log(mySymbol1 === mySymbol2); //false
console.log(mySymbol1.description);
if(mySymbol){
    console.log('있어요!');
}
*/

/*
const s1 = Symbol.for('mySymbol');
// global symbol registry라는 곳이 있음
// 일단 거기에서 해당 인자를 키로 가지고 있는 symbol을 찾음
// 만약 존재하지 않으면 symbol을 만들고
// global symbol registry에 등록하고 symbol을 리턴
// 
const s2 = Symbol.for('mySymbol');
console.log(s1 === s2) //true
console.log(Symbol.keyFor(s2)); //mySymbol
*/

/*
const Direction = {
    'UP':Symbol(), //겹치지 말아야 할 값을 동적으로 사용하기 위해
    'DOWN':Symbol(),
    'LEFT':Symbol(),
    'RIGHT':Symbol()
}
let myDirection = Direction.DOWN;
if(myDirection == Direction.DOWN){
}
*/

// console.log(1 + 2); //3
// console.log(1 + '2'); //12
// console.log(1+true); //2
// console.log(1 + null); // 1
// console.log(1 + undefined); //NaN

console.log(typeof String(1)); // string
console.log(typeof String(NaN)); // string

console.log(typeof (1).toString()); //내부적으로 wrapper객체가 호출됨