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
        x : <input type="text" name="x" id="x"><br/>
        y : <input type="text" name="y" id="y"><br/>
        <button id="btnSum" type="button">더하기</button>
        <button id="btnSub" type="button">빼기</button>
        <button id="btnMul" type="button">곱하기</button>
        <button id="btnDiv" type="button">나누기</button>
        <div id="result"></div>
    </form>
</body>
</html>
<script>
	window.onload=function(){
	    document.getElementById("btnSum").addEventListener("click", cul);
	    document.getElementById("btnSub").addEventListener("click", cul);
	    document.getElementById("btnMul").addEventListener("click", cul);
	    document.getElementById("btnDiv").addEventListener("click", cul);
	}
	
    var xhttp = new XMLHttpRequest();
    xhttp.onload = function(){
        document.getElementById("result").innerHTML = this.responseText;
    }
    
    function cul(event){
    	var x = document.getElementById("x").value;
    	var y = document.getElementById("y").value;
    	var op = event.target.id;
    	let url = "operation_receive.jsp?x="+x+"&y="+y+"&op="+op;
    	loadData(url);
    }
    
    
    
    function loadData(url){
	    //console.log(url);
	    xhttp.open("GET", url, true);
	    xhttp.send();
    } 
</script>