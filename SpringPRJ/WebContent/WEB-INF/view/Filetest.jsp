<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="poly.dto.NoticeDTO"%>
<%@page import="poly.util.CmmUtil"%>
<%
		NoticeDTO rDTO = new NoticeDTO();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>이미지 업로드 </h2>
	<form name="form1" method="post" enctype="multipart/form-data" 
	action="FileUpload.do">
	<br/>
	이미지 업로드 : <input type="file" name="fileUpload" />
	<br/>
	<br/>
	<!-- img_file을 불러올때 script로 파일명 불러오고, 경로마지막에 붙여주기  -->
	<img id="imgNotice" name="imgNotice" src="/Notice_imgs/<%
	rDTO.getContent(); %>" width='100px' height='100px'>
	<input type="submit" value="전송">
	</form>
</body>
</html>