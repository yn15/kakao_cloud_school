// Array.prototype.map()

// const array1 = [1, 4, 9, 16];

// const let1 = array1.map((x) => {
//     return x*2;
// })


// const let1 = array1.map((x) => x*2);

// console.log(let1);

// filter는 주어진 함수의 테스트를 통과하는 모든 요소를 모아 새로운 배열로 변환

const words = ['세종대왕', '이황', '강감찬', '샤인머스켓', '소리없는 아우성'];

// 글자길이가 3자를 초과하는 데이터만 추려서 새로운 배열 생성

const filter = words.filter((x)=> x.length>3)

console.log(filter);