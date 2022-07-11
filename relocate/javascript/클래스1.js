class User{
    constructor(name="", age=0){ 
        console.log("생성자");
        this.name = name;
        this.age = age;
    }

    sayHi(){
        console.log(this.name, this.age);
    }
}

let user = new User("Tom");
user.sayHi();
user.age=12;
console.log(user.age);

user = new User();
console.log(user);
