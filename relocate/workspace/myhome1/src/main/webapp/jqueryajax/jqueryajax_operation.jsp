<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
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
	$(()=>{
		$("button").click((e)=>{
			$.ajax({ 
				url:"operation_receive.jsp", //메소드 기입안하면 자동으로 GET으로 지정됨
				dataType:"json", //받을 때 json으로 받겠다고 했으므로 parsing이 필요없다.
				data:{x:$("#x").val(), y:$("#y").val(), op:e.target.id}
			   })
			 .done((result)=>{   
				 if(result.result=="success"){
					 $("#result").html(result.value);
				 }
				 console.log($(this));
			  })
			 .fail((jqXhr, error) => {
				 console.log(error);
			 })
		})
	})
	
</script>