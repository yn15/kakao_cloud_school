<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.rapa.control.guestbook.*" %>
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
	<h1>방명록</h1>
	<div class="container">
		<table class="table" id="mytable">
			<thead class="thead-dark">
				<th>번호</th>
				<th>제목</th>
				<th>내용</th>
				<th>작성자</th>
				<th>날짜</th>
			</thead>
			<tbody id="tbody">
			</tbody>
		</table>
		
		<p></p>
		
		<ul id="bookList">
			
		</ul>
		
	</div>
	<% List<GuestbookDto> booklist = (List<GuestbookDto>)request.getAttribute("dataList");
	%>
</body>
</html>
<script>
	$(()=>{
		init();
		
	})
	
	function init(){
		let temp;
		
		<%	
			for(int i = 0; i<booklist.size(); i++){
		%>		
			    temp = "<tr>";
				temp += "<td>"+<%=booklist.get(i).getId()%>+"</td>";
				temp += "<td><a href="+"<%=request.getContextPath()%>"+"/guest.do?cmd=view&id="+
				<%=booklist.get(i).getId()%>+">"+"<%=booklist.get(i).getTitle()%>"+"</a></td>";
				temp += "<td>"+"<%=booklist.get(i).getContents() %>"+"</td>";
				temp += "<td>"+"<%=booklist.get(i).getWriter() %>"+"</td>";
				temp += "<td>"+"<%=booklist.get(i).getWdate() %>"+"</td>";
				temp += "</tr>"
				$("#tbody:last").append(temp);

		<%}%>
	}
	
	
</script>