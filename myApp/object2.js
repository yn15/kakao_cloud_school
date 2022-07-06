//'use strict'; 

// const person = {
//     name: 'Lee'
// };

// // 객체 확장이 가능한지
// console.log(Object.isExtensible(person)); // true

// person.age = 20;
// console.log(person); // { name: 'Lee', age: 20 }

// Object.preventExtensions(person);
// person.address = '서울'; 
// console.log(person); // { name: 'Lee', age: 20 } 추가 되지 않음

// Object.seal(person);
// delete person.name;
// console.log(person); // { name: 'Lee', age: 20 } 삭제 되지 않음

// Object.freeze(person);
// person.name = '아이유';
// console.log(person); // { name: 'Lee', age: 20 } 변경 되지 않음

// --------------------------------------------

//객체 literal을 이용한 객체 생성
// const person1 = {};
// console.dir(person1);

// //생성자 함수를 이용한 객체 생성 => instance
// const person2 = new Object();
// console.dir(person2);
// ------------------------------------


// var tmp = String(true);
// console.log(tmp);
// ----------------------------------------

// 생성자 함수의 이름 식별자는 PascalCase
// function Person() {

// }

// const person1 = Person();
// console.log(person1); // undefined

// // 생성자 함수
// // intstance를 생성하고 내부적으로 this에 binding하게됨
// // this를 리턴하게됨
// const person2 = new Person();   
// console.log(person2); // Person {}

// var person3 = {}
// console.log(person3); // {}
// -----------------------------------------------

// function Person() {
//     // this
//     // this라는 keyword는 생성자 함수일 경우도 있고
//     // 일반 함수인 경우도 있음
//     // 생성자 함수에서의 this => 생성자 함수에 의해서
//     // 만들어질 instance를 가리키는 reference (Person 객체)
//     // 일반 함수에서의 this => window
//     console.log(this);
// }

// //Person();
// new Person();

// --------------------------------------
// function Person(name){
//     this.name = name;
//     this.getName = function(){
//         return `내 이름은 ${this.name}`;
//     }
//     return 100;
// }

// const person1 = new Person('아이유');
// const person2 = new Person('김연아');

// console.log(person1.getName());
// console.log(person2.getName());
// ---------------------------------------

// function foo() {}

// foo.myName = '홍길동';
// foo.getName = function(){
//     console.log(this);
// }

// foo(); // 함수 호출
// new foo(); // 생성자 함수 호출
// //함수객체 [Function: foo] { myName: '홍길동', getName: [Function (anonymous)] }  출력
// foo.getName(); // method 호출   

// ------------------------------------

// function foo() {}

// foo();
// new foo();

// -----------------------------------

// // 함수 선언문
// function foo() {}

// // 함수 표현식
// var bar = function() {};

// // 객체의 property로 함수가 할당
// const barx ={
//     x : function() {}
// }

// //foo 함수 객체가 내부 메소드 [[Constructor]]를 가지고 있음
// new foo(); 

// // 내부 메소드 [[Constructor]]를 가지고 있음
// new bar();

// // 내부 메소드 [[Constructor]]를 가지고 있음
// new barx.x();

// // [[Constructor]] 없음
// const arrow = () => {}

// new arrow(); // arrow is not a constructor


// // [[Constructor]] 없음
// const obj ={
//     x() {

//     }
// }

// new obj.x(); // obj.x is not a constructor
// ----------------------------------------------------
// 함수 선언문
// function add(x,y) {
//     return x + y;
// }

// var inst = new add();

// console.log(inst); // add {}

// function createUser(name, role){
//     return {name, role};
// }

// inst = new createUser();
// console.log(inst);

// //생성자 함수
// function Circle(radius){
//     this.radius = radius;
//     this.getDiameter = function(){
//         return 2*this.radius;
//     }
// }

// const circle = Circle(5); //this가  window 객체를 가르킴
// console.log(radius); // 5
// console.log(circle); // undefined  return구문 없음

// ------------------------------------

// var obj = {
//     name: '홍길동'
// }

// console.dir(obj);

// function squre(number){
//     return number * number;
// }

// console.dir(squre);

// -----------------------------

// function foo(f) {
//     return f();
// }

// function bar(){
//     return 'caller:' + bar.caller;
// }

// console.log(bar());  // caller:null

// console.log(foo(bar)); 
// caller:function foo(f) {
//     return f();
// }

// ----------------------------------

// var obj = {
//     name: '홍길동'
// }

// function square(number){
//     return number * number;
// }

// console.dir(obj);
// console.dir(square);

// ----------------------------------

// 생성자 함수로 사용할목적
// 함수 선언문
// function Person(name) {
//     // 생성자 함수로 만들어질 instance가
//     // 가지는 property를 설정
//     this.name = name;

// }

// const person1 = new Person('홍길동');
// const person2 = new Person('김길동');

// console.log(person1.__proto__);

// -------------------------

// var obj = {};

// function person() {};

// console.dir(obj);
// console.dir(person);

// ----------------------------------

//비효율적 코드
// function Circle(radius){
//     this.radius = radius;
//     this.getDiameter = function(){
//         return 2 * this.radius;
//     }
// }

// const circle1 = new Circle(5);
// const circle2 = new Circle(10);

// // 메소드는 각 인스턴스마다 property(getDiameter)를 가지고 있음
// // 비효율적
// // Circle.protype에 넣는것이 효율적
// console.log(circle1.getDiameter === circle2.getDiameter);  //false

// --------------------------------------
//효율적 코드

// function Circle(radius){
//     this.radius = radius;
//     Circle.prototype.getDiameter = function(){
//         return 2 * this.radius;
//     }
// }

// // 각 객체에 getDiameter가 생성되지 않았기 떄문에
// // prototype까지 링크되어 상속받아 getDiameter을 사용하게 됨
// const circle1 = new Circle(5);
// const circle2 = new Circle(10);

// console.log(circle1.getDiameter === circle2.getDiameter); //true

// ---------------------------------------------

// function Circle(radius){
//     this.radius = radius;
//     Circle.prototype.getDiameter = function(){
//         return 2 * this.radius;
//     }
//     // 공용변수
//     Circle.prototype.name = '홍길동';
// }

// const circle1 = new Circle(5);
// const circle2 = new Circle(10);

// console.log(circle1.name, circle2.name);
// // circle1.name = '아이유';  // circle1 객체에 name property를 추가하게 됨 -> 공유되지 않음

// // Circle.prototype.name = '아이유'  // prototype 객체 바뀜 -> 공유됨

// circle1.__proto__.name = '아이유';  // prototype 객체 바뀜 -> 공유됨
// console.log(circle1.name, circle2.name);

// // function Lec(radius){
// //     this.radius = radius;
// // }

// // Lec.prototype = Circle.prototype;

// // const lec1 = new Lec(1);
// // console.log(lec1.name);

// console.log(circle1.__proto__.constructor); //생성자 함수를 가르키게됨

// -----------------------------------------------------------


//Rest parameter
// function foo(param1, ...args){
//     // [Arguments] { '0': 1, '1': 2, '2': 3, '3': 4, '4': 5 }
//     console.log(arguments);
//     // [ 2, 3, 4, 5 ]
//     console.log(args);

//     return args.pop();
// }

// var result = foo(1, 2, 3, 4, 5);
// console.log(result);  // 5