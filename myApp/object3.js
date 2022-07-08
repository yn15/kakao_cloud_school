// function Person(name){
//     this.name = name;
// }

// const person = new Person('홍길동');
// console.dir(person);
// console.dir(Person);
// console.dir(Person.prototype.__proto__.__proto__);

// ------------------------------------------

// const obj = {};

// const parent = {x: 1};

// obj.__proto__ = parent;  // 상위 prototype을 대채하고 상속

// console.log(obj.x); // 1

// ---------------------------------------------------------

// const obj = {}; // 객체 literal로 만든 객체

// console.dir(obj.__proto__.constructor.name) // Object

// -------------------------------------------------------------

// 객체 생성하는 방법]]
// 객체를 생성할 때 객체의 상위 prototype객체를 직접 지정할 수 있음
// const obj = Object.create(null);
// //console.log(obj.__proto__); //undefined    // __proto__를 사용할 수 있게 되는 상위 prototype객체가 null로 지정되서 사용 불가

// console.log(Object.getPrototypeOf(obj));

// -------------------------------------------------------

// 함수표현식
// var foo = function() {};

// console.log(foo.__proto__ === Function.prototype); // true

// console.log(foo.prototype.__proto__ === Object.prototype); // true

// console.log(Object.prototype.__proto__); // null //prototype의 최상위

// console.log(foo.constructor == Function); //

// console.log(foo.__proto__.__proto__.constructor.name);

// ----------------------------------------

// console.log(Object === window.Object); //ture
// console.log(Object === globalThis.Object);

// console.log(Object.__proto__);

// ----------------------------------

// function Person(name){
//     this.name = name;
//     // instance 함수
//     // this.getName = funtion(){}
// }

// // prototype 함수
// Person.prototype.sayHello = function(){
//     console.log(`안녕하세요!!!!!!!! ${this.name}`);
// }


// // instance를 생성
// const person1 = new Person('Mr.홍');
// person1.sayHello();

// // overriding
// person1.sayHello = function(){
//     console.log(`반가워요!!!!!!!!!!!!! ${this.name}`);
// }

// // 만약 overriding이 발생하면 이 발생된 overriding에 의해서
// // 숨겨진 prototype 메소드를 property shadowing되었다고 말함
// person1.sayHello();

// --------------------------------------

// function Person(name) {
//     this.name = name;
// }

// // 객체가 prototype을 대체 됨
// Person.prototype = {
//     sayHello() {
//         console.log('난 알아요!');
//     }
// }

// const me = new Person('홍낄낄');

// // instance와 대치된 prototype 객체에는 constructor 이 없으므로
// // Object.prototype의 constructor을 찾게됨
// console.log(me.constructor === Object);

// -------------------------------------------

// function Person(name) {
//     this.name = name;
// }

// // 객체가 prototype을 대체 됨
// Person.prototype = {
//     constructor: Person,
//     sayHello() {
//         console.log('난 알아요!');
//     }
// }

// const me = new Person('홍낄낄');

// console.log(me.constructor === Person);

// -------------------------------------------

// function Person(name) {
//     this.name = name;
// }


// const me = new Person('홍낄낄');

// const parent = {
//     sayHello()  {
//         console.log('안녕하세요!');
//     }
// }

// // me의 상위 prototype을 parent로 대치
// Object.setPrototypeOf(me, parent);

// console.log(me.__proto__ === Person.prototype); //false

// console.log(me.__proto__ === parent); // true

// -------------------------------------------------

// static property / method

// function Person(name) {
//     this.name = name;
//     // instance 메소드
//     this.callme = function() {  }
// }

// // prototype 메소드
// Person.prototype.sayHello = function() {
//     console.log('안녕안녕안녕안녕안녕안녕!!!!');
// }

// // 객체 자체에 붙는 메소드 : static method
// // instance 생성해서 사용 불가
// Person.staticMethod = function() {
//     console.log('헬로우하이쒜쒜');
// }

// Person.staticMethod();

// const person = new Person('홍길동');

// person.__proto__.constructor.staticMethod();


// ------------------------------------------------

// function foo() {
//     // ReferenceError이어야 정상 
//     // 선언을 하지않으면 implicit globlal(묵시적 전역) 동작
//     // window 객체에 x 전역변수 생성됨
//     x = 10; // 전역변수화(window객체의 property로 붙어요!!)
// }

// foo();

// console.log(x); // 10

// ---------------------------------------------------

// 'use strict';

// function foo() {
//     x = 10;
// }

// foo();

// console.log(x); // 10

// ---------------------------------------------------------

//IIFE
// (function() {
//     // non-strict mode
//     var let = 10;
//     // inner function OR nested function
//     function foo() {
//         'use strict'
//         let = 20; // SyntaxError
//     }

//     foo();
// }());

// -----------------------------------

// 'use strict'

// var obj = {}

// delete obj;

// -------------------------------------------

// var obj = new Object();

// var str = 'Hello'; // primitive value
//                    // data type : string

// // 'Hello'.toUpperCase(); // new로 객체화 됨

// str.toUpperCase(); // wrapper 객체 생성되고 이 줄이 끝나면 소멸됨
// str.toLowerCase(); // 다시 만들고 또 사라짐
// // 계속 이런 구문을 사용시 비효율적
// // 그냥 생성자를 이용하는게 나을지도?

// var strObj = new String('홍길동'); // built-in 생성자 함수

// console.dir(typeof strObj); // Object
// console.dir(strObj); // 유사배열 객체 존재
// // [[PrimitiveValue]]를 가지고 있는 객체를 wrraper 객체라고함


// -----------------------------------

// var obj = {}; // 전역 코드

// // 전역 코드
// function myFunc() {
//     // 함수코드
//     console.log('Hello');
//     // nested function, inner function, 중첩함수
//     function sayHello(){ // myFunc의 함수코드
//         console.log('하이'); // sayHello의 함수코드
//     }
// }

// myFunc();  // 전역코드

// -------------------------------------

// const x = 1;

// function foo() {
//     const y = 2;
//     function bar() {
//         const z = 3;
//         console.log(x+y+z);
//     }
//     bar();
// }
// foo();

// ------------------------------------

// const x = 1;

// function outer() {
//     const x = 10;

//     const inner = function() {
//         console.log(x);
//     }

//     return inner;
// }

// const innerFunc = outer();
// innerFunc(); // 10 
// // outer 내부에 있는 x에 대한 참조가 끝나지 않았기때문에 lexcical enviorment(메모리)에 GC되지 않고 남아 있음
// // 이것이 closure


// function foo(){
//     const x = 1;
//     const y = 2;
//     // closure가 아님
//     function bar(){
//         const z= 3;
//         console.log(z);
//     }
//     bar();
// }

// const bar = foo();
// // x, y는 참조하는 게 없어서 lexcial enviorment에서 삭제됨
// bar();

// ------------------------------------------------------

// let num = 0;

// const increase = function() {
//     return ++num;
// }
// // 아무곳이나 값을 변경할 수 있다는 문제 존재
// console.log(increase()); // 1
// console.log(increase()); // 2
// console.log(increase()); // 3

// --------------------------------------------


// // 데이터를 보호하는 하나의 방법
// const increase = function() {
//     let num = 0;
//     return ++num;
// }
// console.log(increase()); // 1
// console.log(increase()); // 1
// console.log(increase()); // 1

//-----------------------------------------------

// closure로 데이터 보호

// const increase = (function (){
//     let num = 0;
//     return function() {
//         return ++num;
//     }
// }());

// console.log(increase()); // 1
// console.log(increase()); // 2
// console.log(increase()); // 3

// ---------------------------------------

// const counter = (function (){
//     let num = 0;
    
//     return {
//         increase(){
//             return ++num;
//         },
//         decrease(){
//             return --num;
//         }
//     }
// }());

// console.log(counter.increase()); // 1
// console.log(counter.increase()); // 2
// console.log(counter.decrease()); // 1
// console.log(counter.decrease()); // 0