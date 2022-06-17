let person = {"name":"홍길동", "age":23, "phone":"010-0000-0000"};

for(const [key, value] of Object.entries(person)){
    console.log(`${key} ======> ${value}`);
}

let students = [
    {"name":"홍길동", kor:90, eng:90, mat:80},
    {"name":"장길산", kor:80, eng:80, mat:100},
    {"name":"임꺽정", kor:70, eng:70, mat:90},
    {"name":"장승업", kor:60, eng:80, mat:60},
    {"name":"홍경래", kor:70, eng:50, mat:40}
];

console.log(`객체의 개수 : ${students.length}`);
console.log(students[0].name);
console.log(students[0]["name"]);
console.log(students[0]["kor"]);

//데이터 추가하기
students.push({name:"김성훈", kor:100});
for(i in students){
    console.log(students[i].name, students[i]["kor"], students[i]["eng"]);
}

for(item of students){
    console.log(item.name, item.kor, item["eng"], item["mat"]);
}

let myproduct={
    "product_name":"노트북",
    "product_info":[
        {company:"회사1", model:"modelAAA", price:2000000},
        {company:"회사2", model:"modelBBB", price:1400000},
        {company:"회사3", model:"modelVVV", price:2700000}
    ]
}

console.log(myproduct.product_name);
for(item of myproduct.product_info){
    console.log(item.company, item.model, item.price);
}

let s = JSON.stringify(person); //JSON -> String 변환
console.log(person);
console.log(s);
console.log(s.name);

let person2 = JSON.parse(s); //String -> JSON 변환
console.log(person2.name);

s = JSON.stringify(myproduct);
console.log(s);

m1 = JSON.parse(s);
console.log(m1);