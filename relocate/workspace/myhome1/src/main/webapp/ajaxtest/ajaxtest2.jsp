<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="myform" id="myform">
        아이디 : <input type="text" name="userid" id="userid"><br/>
        <button id="btnCall" type="button">ajax</button>
        <div id="result"></div>
    </form>
</body>
</html>
<script>
	window.onload=function(){
	    document.getElementById("btnCall").addEventListener("click", loadData);
	}
	
    var xhttp = new XMLHttpRequest();
    xhttp.onload = function(){
        console.log(this.responseText);
        document.getElementById("result").innerHTML = this.responseText;
    }
    function loadData(){
	    let url = "receive1.jsp?userid="+document.getElementById("userid").value;
	    console.log(url);
	
	    xhttp.open("GET", url, true);
	    xhttp.send();
    }
</script>