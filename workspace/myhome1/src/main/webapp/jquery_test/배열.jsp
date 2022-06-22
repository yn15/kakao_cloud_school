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
	<input type="text" name="numbers" value="1"><br/>
	<input type="text" name="numbers" value="3"><br/>
	<input type="text" name="numbers" value="11"><br/>
	<input type="text" name="numbers" value="14"><br/>
	<input type="text" name="numbers" value="21"><br/>
	<input type="text" name="numbers" value="15"><br/>
	<input type="text" name="numbers" value="17"><br/>
	<input type="text" name="numbers" value="19"><br/>
	<input type="text" name="numbers" value="23"><br/>
	<input type="text" name="numbers" value="12"><br/>
	-----------------------------------<br/>
	<div id="result"></div>
	<button id="btnAdd" type="button">합산하기</button>
	
</body>
</html>
<script>
	$(function(){
		let sum = 0;
		$("#btnAdd").click(function(){
			sum = 0;
			$("input[type=text]").each(function(){
				sum += parseInt($(this).val());
			})
			
			console.log(sum);
			$("#result").html(sum);
		})
	})
</script>
