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
	window.onload=function(){
	    loadData();
	}
	
	function loadData(){
	    var xhttp = new XMLHttpRequest(); //비동기 통신 담당 객체
	
	    //통신 중간 중간 이 필드에 전달된 함수를 호출한다
	    xhttp.onreadystatechange = function(){
	        //console.log(this.readyState, this.status);
	        if(this.readyState == 4 && this.status==200){
	        	//var data = JSON.parse(this.responseText);
	        	var data = JSON.parse(this.responseText);
	        	addtd(data)
	        }
	    };
	
	    xhttp.open("GET", "json2.jsp", true);
	    xhttp.send();
	}
	
	function addtd(tableData){
		//console.log(tableData.data);
		let tbody = document.getElementById("tbody");
		document.getElementById("total").innerHTML="총수량"+tableData.totalCnt;
		tableData.data.forEach((item)=>{
			/* let temp = "<tr>";
			temp += "<td>"+item.id+"</td>";
			temp += "<td>"+item.title+"</td>";
			temp += "<td>"+item.writer+"</td>";
			temp += "<td>"+item.hit+"</td>";
			temp += "</tr>"
			$("#tbody:last").append(temp); */
			let row = tbody.insertRow(tbody.rows.length);
			row.insertCell(0).innerHTML = item.id;
			row.insertCell(1).innerHTML = item.title;
			row.insertCell(2).innerHTML = item.writer;
			row.insertCell(3).innerHTML = item.hit;
		})
	}
</script>