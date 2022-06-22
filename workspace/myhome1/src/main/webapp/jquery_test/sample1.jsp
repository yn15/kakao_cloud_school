<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
</head>
<body>
	//자기의 contextpath를 불러온다
	//다른 폴더에서 작업시 src의 주소를 변경해줄 필요가 없음
	<%=request.getContextPath()%>
	url : http://127.0.0.1:9090/myhome1/jquery_test/sample1.jsp
</body>
</html>
<script>
	$(()=>{
		alert("jquery");
	});
</script>