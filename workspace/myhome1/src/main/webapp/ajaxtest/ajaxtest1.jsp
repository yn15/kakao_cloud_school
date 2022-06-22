<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div id="demo"></div>
    <button id="btnCall" type="button">부르기</button>
</body>
</html>
<script>
    window.onload=function(){
        document.getElementById("btnCall").addEventListener("click", loadData);
    }

    function loadData(){
        var xhttp = new XMLHttpRequest(); //비동기 통신 담당 객체

        //통신 중간 중간 이 필드에 전달된 함수를 호출한다
        xhttp.onreadystatechange = function(){
            console.log(this.readyState, this.status);
            if(this.readyState == 4 && this.status==200){
                document.getElementById("demo").innerHTML = this.responseText;
            }
        };

        xhttp.open("GET", "ajax_info.txt", true);
        xhttp.send();
    }

    
</script>