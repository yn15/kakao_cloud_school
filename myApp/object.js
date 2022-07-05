// 'key': 'value' :다음에 한칸 띄는게 권장되는 표기법

// var obj = {
//     name: '홍길동',
//     printName: function myPrint(){
//         console.log(`내 이름은 ${this.name}!`)
//     },
//     "!myPhone": '010-1234-5678',
//     10: 300 //key는 문자열 캐스팅
// };

// console.log(typeof obj); //object

// ---------------------------------------


// var obj = {
//     myName: '홍길동'
// }

// obj.myAge = 20;
// obj['!myPhone'] = '010-1231-3242';
// obj['myAge'] = 30;
// console.log(obj);

// delete obj.myAge;
// console.log(obj);

// -----------------------------------------------

// var obj = {
//     10: 100,
//     let: '권장되지 않음',
//     myName: '홍길동',
//     '!myName': '김길동',
//     myName: '김연아'
// }

// console.log(obj);
// console.log(obj.myAddress); //undefined

// ---------------------------------------------

// let x = 1;
// let y = 2;

// const obj = {x, y}; //확장 표현 방식

// console.log(obj);

// // let myObj = {
// //     name: '홍길동',
// //     printName: function(){
// //         console.log(this.name);
// //     }
// // }

// let myObj = {
//     name: '홍길동',
//     printName(){  //Javascript의 명시적 메소드 (축약 표현)
//         console.log(this.name);
//     }
// }

// myObj.printName();

// -------------------------------------------------

// let myStr = 'Hello';

// // primitive type을 맡치 객체(배열)처름 사용
// console.log(myStr[0]); //H   //내부슬롯(객체) 생성 // 유사 배열 객체(array-like object)
// console.log(myStr.length); //5

// myStr[0] = 'h'; // 내부슬롯의 0번 요소만 바꾸기 때문에 primitiv값읜 Hello는 바뀌지 않았음

// console.log(myStr); // Hello

// ---------------------------

// var myFunc = function add(x, y){
//     return x+y;
// }

// //console.log(add(3, 5));
// console.log(myFunc(3,5));

// --------------------------------------

//함수 선언문
// function foo(){
//     console.log('foo 함수');
// }

// //함수 리터럴(표현식이 됨)
// (function bar(){
//     console.log('bar 함수');
// })

// bar(); //bar is not defined

// -------------------------------------------------
// foo(); //호출 됨
// add(); //add is not a function

// //함수 선언문
// function foo(){
//     console.log('foo 함수');
// }



// //함수 표현식
// var add = function bar(){
//     console.log('bar 함수');
// }
// ---------------------------------------

// //함수 선언문
// function add(){
//     //arguments //call을 할때 받는 매개변수를 받아두는 곳  (유사배열객체)
//     let sum = 0;
//     for(let i = 0; i<arguments.length; i++){
//         sum += arguments[i];
//     }
//     return sum;
//     //return x + y;
// }

// console.log(add(2)); //NaN (호출가능)
// console.log(add(2, 3, 4));

// -----------------------------------------------


//call
// function add() {
//     let x = 10;
//     let y = 20;

//     console.log(x + y);
// }

// //invoke
// add();
//------------------------------------------

//IIFE
// (function add() {
//     let x = 10;
//     let y = 20;

//     console.log(x + y);
// }());
// -------------------------------------------


// var x = 100; //global scope (전역변수)
// var y = 200; //global scope (전역변수)

// // outer function
// function outer(){
// 	let x = 0; // function level scope(지역변수)
	
// 	// inner function
// 	function inner() {
// 		let x = 10;  // function level scope(지역변수)
// 		console.log(y);
// 	}
// }

// ----------------------------------------


// 잘만든 함수가 존재!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
// 그런데 이 함수의 기능을 변경(추가)
// 1.원래 있던 함수를 수정!
// 2.함수를 새로 추가해서 만들어요!
// 3.함수를 추상화 시켜서 인자로 받아서 사용!
// function repeat(n){
//     for(var i=0; i<n; i++){
//         console.log(i);
//     }
// }

// function repeat(n){
//     for(var i=0; i<n; i++){
//         if(i % 2 == 1)
//             console.log(i);
//     }
// }

//고차 함수(Higher-Ordered Function)
// function repeat(n, f){ 
//     for(var i=0; i<n; i++){
//         f(i);
//     }
// }

// let logAll = function(i){
//     console.log(i);
// }

// let logOdd = function(i){
//     if(i%2){
//         console.log(i);
//     }
// }

// repeat(10, logAll);
// repeat(10, logOdd);
// ---------------------------------------------------

// var x = 1; // 전역 scope의 전역 변수

// function foo(){
//     var x = 10;
//     bar();
// }

// function bar(){
//     console.log(x);
// }

// foo(); // 1

// ------------------------------------------------