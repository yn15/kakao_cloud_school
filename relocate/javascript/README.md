# javascript 학습

## **반복문**

> 기본 for문
```javascript
    for(i = 0; i<flowers.length; i++)
        console.log(flowers[i]);
```
> for...in문
```javascript
    for(i in flowers)
        console.log(i, flowers[i]);
```
> for..of문
```javascript
    for(item of flowers)
        console.log(item);
```

> forEach문
```javascript
    flowers.forEach((x) => console.log(x));
```

------
## **sapn 태그**
- HTML 문서에서 인라인 요소(inline-element)들을 하나로 묶을 때 사용

---
## **document**
- HTML 문서에 대한 정보를 갖고 있음

---
## **innerHTML**
- 해당 태그 안의 태그포함 문서를 변경

---
## **innerText**
- 해당 태그 내의 Text만 변경

---

## **"user strict"**
- 스크립트 내부의 첫 줄에 기술
- 변수를 반드시 선언하도록 하고자 하면 이 키워드를 사용

---

## **변수 선언**
- var, val, let 으로 선언

---

## **호이스팅**
- 한 변수명의 타입과 값을 자유롭게 변경가능

---

## **특수타입**
- ```undefined```는 시스템이 부여하는 값, 직접 정의해선 안됨, 값이 할당되지 않음
- ```null```은 할당됐지만 유효하지 않은값

---

## **배열**
- [1, 2, 3, 4] 식으로 선언
- 변수명.push로 삽입
- ```변수명.concat("1", "2")``` 기존의 배열에 해당 리스트를 결합함
- ```배열명.join()``` 배열의 요소를 결합하여 문자열로 반환
- ```배열명.spit(" ")``` 문자열을 기준 문자로 나누어 배열로 반환

---

## **등호연산자**
- ```===```은 자동형변환하여 변환하지 않음

---

## **Json 객체**
- ```let person = {"name":"홍길동", "age":18};``` 형식
- ```person["name"]``` 또는 ```person.age``` 형식으로 값 접근 가능

## **함수**
- ```function showMessage(text) { }``` 형식으로 기술
- 매개변수를 전달하지 않을 경우 text에는 ```undifined```가 정의됨
- 함수를 변수에 저장시 해당 코드에 도달할 시점에 함수가 생성됨
- **함수 선언문** 
  - ```function 함수명(){...}```
- **함수 표현식**
  - ```개체 = function(){...}```
- **화살표 함수**
  - ```개체 = () => {...}```

---
## **CallBack 함수**
- 다른 함수의 인자로써 이용되는 함수
- 어떤 이벤트에 의해 호출되어지는 함수

----

## **filter, map, forEach**
- "

---

## **reduce 함수**
- ```javascript
  sum = arr.reduce((pre, curr)=>{
        console.log(`pre : ${pre}`); //앞선값
        console.log(`curr : ${curr}`); //현재값

        return pre+curr; //반드시 리턴이 있어야한다.
    }, 10); //pre에 대입될 수
    ```
---

## **예외 처리**
- ```javascript
    try{}
    catch(e){}
    finally{}
  ```