// var obj = {
//     name: '홍길동'
// };

// console.dir(obj);

// Property Attribute를 확인해 보아요!
// const person = {
//     name: 'Lee',
//     age: 20
// };

// console.log(Object.getOwnPropertyDescriptor(person, 'name'));

// console.log(Object.getOwnPropertyDescriptors(person));

const person = {
    age: 20
};

//person.name = '홍길동';

Object.defineProperty(person, 'name', {
    value: '홍길동',
    writable: false,
    enumerable: false,
    configurable: true
});

console.log(person);

console.log(Object.getOwnPropertyDescriptor(person, 'name'));

person.name = '아이유';

console.log(person);

console.log(Object.keys(person));

for(let idx in person){
    console.log(idx); //property key
    console.log(person[idx]);
}

// for(let value of person){   //아직 Error
//     console.log(value); //property value
// }