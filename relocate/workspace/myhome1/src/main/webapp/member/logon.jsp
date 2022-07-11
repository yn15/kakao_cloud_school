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
	<form>
	  <div class="mb-3 mt-3">
	    <label for="userid" class="form-label">아이디:</label>
	    <input type="text" class="form-control" id="userid" placeholder="Enter id" name="userid">
	  </div>
	  <div class="mb-3">
	    <label for="password" class="form-label">패스워드:</label>
	    <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
	  </div>
	
	  <button type="button" class="btn btn-primary" id="btnLogon" name="btnLogon">Submit</button>
	</form>
</div>
</body>
</html>
<script>
$(()=>{
	$("#btnLogon").click(()=>{
		$.ajax({
			url:"logon_proc.jsp",
			dataType:"json",
			method:"POST",
			data:{userid:$("#userid").val(), pwd:$("#pwd").val()}
		})
		.done((res)=>{
			if(res.result=="success"){
				alert("로그온 성공");
				location.href="<%=request.getContextPath()%>/";
			}else{
				alert("로그온 실패");
			}
		})
		.fail((jqXHR, error)=>{
			console.log(error);
		})
	});
})
</script>