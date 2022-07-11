# JQUERY 학습

## **window.onload function**

> 기본 window.onload 함수
```javascript
    $(document).ready(function(){
        alert("jqeury를 배워봅시다.")
    });
```
> 함수 표기법
```javascript
    $(function () {
        //alert("jquery를 배워봅시다2");
        $("p").click(function(){
            $(this).hide();
        })
    });
```
> 화살표 함수
```javascript
    $(()=>{
        alert("jquery를 배워봅시다3");
    });
```


------
## **참조**
- ```elements(태그들은)``` $("태그명") 으로 참조
- ```id```는 $("#id") 로 참조
- ```class```는 $(".class")로 참조

-----
## **값 읽기, 쓰기
- ```.val()```로 값을 읽음
- ```.val("value")```로 값을 입력

----
## **문서 작성**
- ```.html()```으로 문서 입력

## **이벤트**
- ```javascript
    $("#btnSend").click(function(){
                ...
    })
  ```

- ```javascript
    //json형식으로 여러 이벤트 처리
    $("p").on({
            mouseenter:function(){
            $(this).css("background-color", "lightgray");
            },
            mouseleave:function(){
                $(this).css("background-color", "lightblue");
            },
            click:function(){
                $(this).css("background-color", "yellow");
            }
        });
    ```