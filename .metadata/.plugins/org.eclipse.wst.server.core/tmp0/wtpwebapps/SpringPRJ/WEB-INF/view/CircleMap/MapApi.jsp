<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"/>
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<title>Kakao 지도 시작하기</title>
</head>
<body>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<div>환영합니다</div>
<button onclick="location.href:''/User/UserLogin.do'"> 로그인</button>
	<div id="MapPage">
		<div id="search" style="widtd:80%; height:10%"></div>
		<div id="map" style="width:500px;height:400px;"></div>
		<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=475e789d58d715539c6e2d98dfe2089c"></script>
		<script type="text/javascript" src="MapTec.js"></script>
	</div>
</body>
</html>