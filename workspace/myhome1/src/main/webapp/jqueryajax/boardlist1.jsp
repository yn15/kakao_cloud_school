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
	<div class="container">
		<h2>테이블</h2>
		<p><span id="total"></span></p>
		<table class="table" id="mytable">
			<thead class="thead-dark">
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
			</thead>
			<tbody id="tbody">
			</tbody>
		</table>
		
		<p></p>
		
		<ul id="bookList">
			
		</ul>
		
	</div>
</body>
</html>
<script>
	$(()=>{
		$.ajax({ 
			url:"../ajaxtest/json2.jsp",
			dataType:"json"
		})
		 .done((result)=>{   
			addtd(result);
		})
	})
	
	function addtd(tableData){
		$("#total").html("총 개수 : " + tableData.totalCnt);
		tableData.data.forEach((item)=>{
		let temp = "<tr>";
			temp += "<td>"+item.id+"</td>";
			temp += "<td>"+item.title+"</td>";
			temp += "<td>"+item.writer+"</td>";
			temp += "<td>"+item.hit+"</td>";
			temp += "</tr>"
			$("#tbody:last").append(temp); 
		})
	}
</script>