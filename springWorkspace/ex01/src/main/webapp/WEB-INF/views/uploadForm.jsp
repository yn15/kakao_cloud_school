<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<h1>/view/uploadForm.jsp</h1>

<form action="uploadPro" method="post" entctype="multipart/form-data">
	id : <input type="text" name="id"/> <br/>
	file : <input type="file" name="save" /> <br/>
		<input type="submit" value="전송"/>
</form>