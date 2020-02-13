<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
					"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>타이틀입력</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/style.css" />

</head>
<body>
	<a id = "logo" href="./main">
	<img src="https://www.multicampus.com/img/saas/main/logo/CUS0001/pc_main.png" >
	</a>
	
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
	<h3>역삼역 멀티캠퍼스 외부의 식당들을 리뷰해주세요. </h3>
	<form id="insertform" action="./listMCREV" method="post">
	<table id="insertformMCR">
	<tr><th>제목</th><td><input type="text" name="title" maxlength="100"></td></tr>
	<tr><th>작성자</th><td><input type="text" name="writer"></td></tr>
	<tr><th>내용</th><td><textarea name="contents" rows=10 cols="50"></textarea></td></tr>
	</table>
	<input type="submit" value="글쓰기 완료"> 
	</form>
	<hr>
	


	<nav id="topMenu" class="menu">
	<ul>
		<li><a class="menuLink" href="./useticket">식권사용</a></li>
		<li><a class="menuLink" href="./buyticket">식권구매</a></li>
		<li><a class="menuLink" href="#">포인트충전</a></li>
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