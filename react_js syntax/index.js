// 1. Map 
// Array.prototype.map()

// const array1 = [1, 4, 9, 16];

// const let1 = array1.map((x) => {
//     return x*2;
// })


// const let1 = array1.map((x) => x*2);

// console.log(let1);

// =========================================================

// 2. filter
// filter는 주어진 함수의 테스트를 통과하는 모든 요소를 모아 새로운 배열로 변환

// const words = ['세종대왕', '이황', '강감찬', '샤인머스켓', '소리없는 아우성'];

// // 글자길이가 3자를 초과하는 데이터만 추려서 새로운 배열 생성

// const filter = words.filter((x)=> x.length>3)

// console.log(filter);

// =================================================================

// 3. 전개 연산자 (Spread Operator) => ...
// let arr1 = [1, 2, 3];
// let arr2 = [4, 5, 6];
// let arr3 = [7, 8, 9];

// // let result = arr1.concat(arr2, arr3);

// let result = [...arr1, ...arr2, ...arr3];
// console.log(result);

// let obj1 = {
//     a: '1',
//     b: '2'
// }

// let obj2 = {
//     c: '3',
//     d: '4'
// }

// // result = {obj1, obj2};
// result = {...obj1, ...obj2};
// console.log(result);


// ========================================================================

// 4. 구조분해 할당(ES6, Destructuring)
// 이 방식을 사용하는 이유는 .. 코드가 간결해지기 때문에
// 객체나 배열의 속성을 분해해서 개별변수에 담을 수 있게 해줌

// let obj = {
//     name: '홍길동',
//     age: 20,
//     address: {
//         zipcode: '123-456',
//         city: '서울'
//     }
// }

// // let {name, age, address} = obj;
// let {address: {zipcode, city}} = obj;

//  let a, b;
 
//  [a, b] = [10, 20];

//  console.log(a);

// sprice

// =======================================================

// 5. splice()
// 배열의 기존 요소를 삭제하거나 교체하기에 적합한 메소드
// rnans
// array.splice(start 위치, 삭제 count, intem1, intem2, ...)
const months = ['1월', '2월', '4월', '5월', '8월'];
// months.splice(2, 0, '3월');
// console.log(months);

// months.splice(3, 1, '7월');
// console.log(months);

let a = months.splice(3, 1);
console.log(a); // ['5월']