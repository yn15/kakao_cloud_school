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
        <h3 style="margin-top:50px">회원가입</h3>
        <div style="margin-top:50px">
            <form name="myform" id="myform" method="post">
                <input type="hidden" id="idcheckyn" value="N">
                    <div class="input-group mb-3">
                        <input type="text" class="form-control" placeholder="아이디를 입력하세요" id="userid" name="userid">
                        <div class="input-group-append">
                            <button class="btn btn-success" id="btnIdCheck" type="button">중복체크</button>
                        </div>
                    </div>
					
                    <div class="input-group mb-3">
                        <input type="password" class="form-control" placeholder="비밀번호를 입력하세요" id="password" name="password">
                    </div>
                    
                    <div class="input-group mb-3">
                        <input type="password" class="form-control" placeholder="비밀번호를 입력하세요" id="password2">
                    </div>
                    
                    <div class="input-group mb-3">
                        <input type="text" class="form-control" placeholder="이름 입력하세요" id="username" name="username">
                    </div>
                    
                    <div class="input-group mb-3">
                        <input type="text" class="form-control" placeholder="전화번호를 입력하세요" id="phone" name="phone">
                    </div>
                    
                    <div class="input-group mb-3">
                        <input type="text" class="form-control" placeholder="이메일를 입력하세요" id="email" name="email">
                    </div>
                    
                    <div class="input-group mb-3">
                        <input type="text" class="form-control" placeholder="주소를 입력하세요" id="address" name="address">
                    </div>
                    
                    <div class="input-group mb-3">
                        <input type="file" class="form-control" placeholder="파일첨부" id="file" name="file">
                    </div>
                    
                    <div class="input-group mb-3" style="justify-content:center">
                        <button class="btn btn-success" id="btnSave" type="button">회원가입</button>
                    </div>
                    
            </form>
        </div>
    </div>
    
</body>
</html>
<script>
/* ID 중복체크 idcheck.jsp */
/* userid --------> test  {"result":"false"}*/
/* 그 밖에 경우는 {} */
/* true이면  idcheckyn 필드의 값을 Y로 바꾼다 */
/* jquery의 경우 prop("readonly", true) */

	$(()=>{
		$("#btnIdCheck").click(()=>{
			$.ajax({ 
				url:"idcheck.jsp",
				dataType:"json",
				method:"POST",
				data:{userid:$("#userid").val()}
			})
			 .done((result)=>{   
				 if(result.result==true){
					 alert("사용 가능한 아이디입니다.");
					 $("#idcheckyn").val("Y");
					 $("#userid").prop("readonly",true);
				 }else{
					 alert("이미 사용중인 아이디입니다.");
					 $("#idcheckyn").val("N");
				 }
			})
			.fail((jqXhr, error) => {
				 console.log(error);
			})
		});
		
		$("#btnSave").click(()=>{
			let parameter = "userid="+$("#userid").val();
			    parameter += "&password="+$("#password").val();
			    parameter += "&username="+$("#username").val();
			    parameter += "&phone="+$("#phone").val();
			    parameter += "&email="+$("#email").val();
			    parameter += "&address="+$("#address").val();
			
			console.log(parameter);
			
			//폼 직렬화는 from태그에 enctype이 지정되어있으면 직렬화가 수행이 안된다.
			parameter = $("#myform").serialize();			
			console.log(parameter);
			
			/* //enctype이 지정되어 있을때
			const formData = new FormData(document.myform);
			
			//첨부파일이 있으면 첨부파일을 별도로 추가를 해야 한다
			formData.append("upload", file.files[0]);
			
			console.log(formData);
			for(key of formData.keys()){
				console.log(key);
			} */
			
			$.ajax({ 
				url:"save.jsp",
				dataType:"text",
				method:"POST",
				data:parameter
			})
			 .done((result)=>{   
				console.log(result);
				location.href="<%=request.getContextPath()%>/index.jsp";
			})
			.fail((jqXhr, error) => {
				 console.log(error);
			})
		})
	})

</script>