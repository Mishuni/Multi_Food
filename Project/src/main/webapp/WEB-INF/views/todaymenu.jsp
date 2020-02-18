<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
					"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>오늘의 식단</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/style.css" />
<script src="<%=request.getContextPath()%>/resources/js/popup.js"></script>
</head>
<body>

	<a id = "logo" href="./mypage">
	<img id="logoimg" src="<%=request.getContextPath()%>/resources/images/logo.png" ></a>
	
	<button id = "logout" class="button" onclick="location.href='./logout'" >로그아웃</button>
	
	
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
	<table class="menutable">
		<tr>
			<th>A코스</th> 
			<th>B코스</th>
		</tr> 
		<tr>
			<td style="">
			<img class="menuimg" alt="A코스"  
			src="<%=request.getContextPath()%>/resources/images/aCourse.jpg"></td>
			<td>
			<img class="menuimg"  alt="B코스"
			src="<%=request.getContextPath()%>/resources/images/bCourse.jpg"></td>
		</tr>
		<tr>
			<td colspan="2">
			<img id="menulist" 
			alt="식단표"  src="<%=request.getContextPath()%>/resources/images/Feb2menu.jpg"">
			</td>
		</tr>
	</table>
	
	<hr>
	


	<nav id="topMenu" class="menu">
	<ul>
		<li><a class="menuLink" onclick= popup(${member.tickets }) >식권사용</a></li>
		<li><a class="menuLink" onclick= popup2(${member.point }) >식권구매</a></li>
		<li><a class="menuLink" onclick= pointpopup() >포인트충전</a></li>
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