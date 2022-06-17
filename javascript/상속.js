class Animal{
    constructor(name=""){
        this.speed = 0;
        this.name = name;
    }

    run(speed){
        this.speed = speed;
        console.log(`${this.name}이 속도 ${this.speed} 로 달립니다.`);
    }

    stop(){
        this.speed=0;
        console.log(`${this.name}이 멈췄습니다.`);
    }
}

class Rabit extends Animal{
    hide(){
        console.log(`${this.name}이 숨었습니다.`);
    }

    //오버라이딩
    stop(){
        super.stop();
        this.hide();
    }
}

let rabbit = new Rabit("흰토끼");
rabbit.run(5);
rabbit.stop();

console.log(rabbit);