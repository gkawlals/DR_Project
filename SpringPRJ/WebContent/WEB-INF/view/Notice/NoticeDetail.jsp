<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="poly.dto.NoticeDTO" %>
    
<%
	NoticeDTO rDTO = (NoticeDTO) request.getAttribute("rDTO");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="detail_">
	<div>
		<input name="detail_delete" type="button" value="삭제" onclick="confirmDelete();">
	</div>
<script type="text/javascript">

	function confirmDelete() {
			if (confirm("삭제할래?")) {
				location.href = "/board/DeletePost.do?no=
				<%=rDTO.getNotice_no()%>";
				}
	
			}	
</script>
	<div>
		<input name="detail_update" type="button" value="수정" onclick="locataion.href='/Notice/UpdateNotice'">
	</div>
</div>
</body>
</html>