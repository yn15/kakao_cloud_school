let person={
    name:"홍길동", age:23, phone:"010-0000-0000",
    display:function(){  //this를 사용하려면 function으로 선언
        console.log(this.name, this.age, this.phone);
        // console.log(name, age, phone); --this생략불가능
    },
    // json안에 화살표 함수는 사실상 사용불가 - this 사용불가
    // display2:()=>{
    //     console.log(this.name, this.age, this.phone);
    // }

    setValue:function(name="", age=10, phone=""){
        this.name = name;
        this.age = age;
        this.phone=phone;
    }
};

person.display();
person.setValue("임꺽정", 33, "011-2222-1111");
person.display();

console.log(person);