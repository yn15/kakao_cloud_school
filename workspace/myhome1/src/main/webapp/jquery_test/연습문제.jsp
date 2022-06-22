<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container-fluid">
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		  <div class="container-fluid">
		    <span class="navbar-text">성적입력</span>
		</nav>
		<p></p>
		이름 : <input type="text" id="name" autofocus><br/><p></p>
		국어 : <input type="text" id="kor"><br/><p></p>
		영어 : <input type="text" id="eng"><br/><p></p>
		수학 : <input type="text" id="mat"><br/>
		<p></p>
		<button type="button" id="btnAdd" class="btn btn-success">추가</button>
		<p></p>
		<table class="table table-striped" id="mytable">
			<thead class="thead-dark">
				<th>이름</th>
				<th>국어</th>
				<th>영어</th>
				<th>수학</th>
				<th>총점</th>
				<th>평균</th>
			</thead>
			<tbody id="tbody">
			</tbody>
		</table>
		<br/>
		
		
		
	</div>
</body>
</html>
<script>
	$(()=>{
		$("#btnAdd").click(()=>{
			init();
			$("#name").val("").focus();
			$("#kor").val("");
			$("#eng").val("");
			$("#mat").val("");
			
			/* $("#name").val(Math.random().toString(36).substring(2, 11)).focus();
			$("#kor").val(Math.random()*10);
			$("#eng").val(Math.random()*10);
			$("#mat").val(Math.random()*10); */
		})
	})
	
	function init(){
		let name = $("#name").val();
		let kor = parseInt($("#kor").val());
		let eng = parseInt($("#eng").val());
		let mat = parseInt($("#mat").val());
		let total = kor+eng+mat;
		let avg = total/3;
		
		let temp = "<tr>"
			temp += "<td>"+name+"</td>";
			temp += "<td>"+kor+"</td>";
			temp += "<td>"+eng+"</td>";
			temp += "<td>"+mat+"</td>";
			temp += "<td>"+total+"</td>";
			temp += "<td>"+avg+"</td>";
			temp += "</tr>"
		$("#tbody:last").append(temp);
	}
	
	
</script>