<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/user/UserLoginProc.do" method="post">
<div id="container" role="main">
	<div id="content">
	  <h2 class="blind">회원가입</h2>
			<div> 
				<span name="IdVal"> 아이디 : </span>	
				<input name="IdText" type="text"></input>
			</div>
			<div> 
				<span name="PassVal"> 비밀번호 : </span>	
				<input name="PassText" type="text" maxlength="16"></input>
			</div>
			<div> 
				<span name="NameVal"> 이름 : </span>	
				<input name="NameText" type="text" ></input>
			</div>
			<div> 
				<span name="EmailVal"> 이메일 : </span>	
				<input name="EmailText" type="email" ></input>
			</div>
			<div> 
				<select id="gender" name="gender" class="sel" aria-label="성별">
					<option value="" selected> 성별 </option>
					<option value="M" > 남자 </option>
					<option value="F " > 여자 </option>
					<option value="U" > 선택안함 </option>
				</select>
			</div>
			<div> 	
				<input name="Login_infor_send" type="submit" value="회원가입"></input>
		</div>
	</div>
</div>
</form>
</body>
</html>