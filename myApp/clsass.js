// // class define
// class Person{
    
// }

// // 익명 class 표현식 // 사용 안해요~~
// const Person = class{}

// // 기명 class 표현식 // 사용 안해요~~
// const Person2 = class MyClass{}

// ----------------------------------------------

// class Person{
//     // constructor(생성자)
//     constructor(name) {
//         // instance의 초기화
//         // instance의 property를 설정
//         this.name = name;
//     }

//     // prototype method
//     // prototype 객체에 생성됨
//     sayHello(){
//         console.log('안녕하세요');
//     }

//     //static method
//     static sayHi(){
//         console.log('요건 static');
//     }
// }

// const person1 = new Person('홍길동');
// console.log(person1.name);
// person1.sayHello();
// Person.sayHi();

// ---------------------------------------

// hoisting
// const Person = '안녕하세요';
// {
//     console.log(Person); // 위의 Person을 참조하고 있어서
//     class Person {} // ReferenceError
// }

// -----------------------------------

// class Person{
//     constructor(name){
//         this.name = name;
//     }
// }

// const me = new Person('홍길동');
// console.dir(me);
// console.dir(Person); // 생성자 함수의 구조와 똑같음

// -------------------------------------------------------------------

// 객체 literal을 이용해서 객체를 생성
// const person = {
//     firstName: '길동',
//     lastName: '호옹',

//     //접근자 형태, 접근제어자 get을 이용, 반드시 return구문이 존재해야함
//     get fullName(){  
//         return `${this.lastName}${this.firstName}`;
//     },

//     set fullName(name){
//         // 유효성을 검사할 수 있다
//         [this.lastName, this.firstName] = name.split(' ') //distructoring
//     }
// }

// // person.lastName = '김'
// // person.firstName = '호오옹동'
// person.fullName = '김 연아';
// console.log(person.fullName); // 함수호출이 아닌 일반적인 참조형태로 호출

// --------------------------------

// class Person {
//     constructor(firstName, lastName){
//         this.firstName = firstName;
//         this.lastName = lastName;
//     }
    
//     get fullName(){  
//         return `${this.lastName}${this.firstName}`;
//     }

//     set fullName(name){

//         [this.lastName, this.firstName] = name.split(' ')
//     }
// }

// const me = new Person('길동', '홍');
// console.log(me.fullName); 
// me.fullName = '김 연아';
// console.log(me.fullName); 

// -----------------------------------------------

// 상위 class(super class)
// class foo {

// }

// // 하위 class(sub class)
// class bar extends foo {

// }

// const obj = new bar();

// console.dir(obj);

// -------------------------------------------

// super class

// class Animal {
//     constructor(age, weight) {
//         this.age = age;
//         this.weight = weight;
//     }

//     eat(){
//         return '밥을 먹어요!!';
//     }

//     move(){
//         return '움직여요!!';
//     }
// }

// // 하위클래스의 instance는 상위클래스에서 만들어짐
// class Bird extends Animal{
//     constructor(age, weight, kk) {
//         // 상위 클래스의 constructor를 호출
//         // 둘의 위치가 바뀌면 안됨
//         super(age, weight); // super호출시 상위객체에서 객체가 만들어져 반환됨
//         this.kk = kk; // 상위에서 만들어진 객체의 레퍼런스에 this를 추가
//     }

//     fly() {
//         return 'I believe~ I can fly';
//     }
// }

// const bird = new Bird(10, 30, 100);
// console.log(bird);
// console.log(bird.move());
// console.log(bird instanceof Bird); // true
// console.log(bird instanceof Animal); // true

// ---------------------------------------------

// function Base(name) {
//     this.name = name;
// }

// class Derived extends Base {

// }

// --------------------------------------

// function Base1(name) {
//     this.name = name;
// }


// class Base2 { }

// let tmp = true;
// // 3항 연산자
// class Derived extends (tmp ? Base1 : Base2){

// }

// --------------------------------------------

// class Base {
//     constructor(name){
//         this.name = name;
//     }

//     sayHello() {
//         return '안녕하세요 :)';
//     }
// }

// class Derived extends Base {
//     sayHello() {
//         return super.sayHello() + this.name;
//     }
// }

// const derived = new Derived('홍길동');
// console.log(derived.sayHello());
// console.log(derived.name);


