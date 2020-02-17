<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
					"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>타이틀입력</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/style.css" />
<script src="<%=request.getContextPath()%>/resources/js/popup.js"></script>
</head>
<body>

	<a id = "logo" href="./mypage">
	<img src="https://www.multicampus.com/img/saas/main/logo/CUS0001/pc_main.png" ></a>
	<a id = "logout" href="./logout">로그아웃</a>
	
	<nav id="topMenu" class="menu">
	<ul>
		<li><a class="menuLink" href="./todaymenu">오늘의 메뉴</a></li>
		<li><a class="menuLink" href="./listREV">식단 후기</a></li>
		<li><a class="menuLink" href="./listSUG">식단 건의사항</a></li>
		<li><a class="menuLink" href="./listMCREV">외부식당 후기</a></li>
	</ul>
	</nav>
	<br>
	
	<hr>
	<!-- 코드작성 -->
	<hr>
	


	<nav id="topMenu" class="menu">
	<ul>
		<li><a class="menuLink" href="#" onclick= popup(${member.tickets }) >식권사용</a></li>
		<li><a class="menuLink" href="#" onclick= popup2(${member.point }) >식권구매</a></li>
		<li><a class="menuLink" href="#" onclick= pointpopup() >포인트충전</a></li>
	</ul>
	</nav>
	<br>
	
	
	
	<footer id="bottom" class="menu">
		<p>Posted by: 유미선, 최혜근, 정헤진, 이효진</p>
		<p>
			Contact information: <a href="mailto:someone@example.com">someone@example.com</a>.
		</p>
	</footer>
	
	
	
</body>
</html>