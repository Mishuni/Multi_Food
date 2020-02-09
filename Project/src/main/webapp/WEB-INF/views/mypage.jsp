<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
					"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>마이페이지</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/style.css" />

</head>
<body>
<img id="logo" alt="" src="https://www.multicampus.com/img/saas/main/logo/CUS0001/pc_main.png">
	<nav id="topMenu" class="menu">
	<ul>
		<li><a class="menuLink" href="#">오늘의 메뉴</a></li>
		<li><a class="menuLink" href="#">식단 후기</a></li>
		<li><a class="menuLink" href="#">식단 건의사항</a></li>
		<li><a class="menuLink" href="#">수업 후기</a></li>
	</ul>
	</nav><br>

	<h1 id="welcome">${user.id }님 안녕하세요!</h1>
	
	<div id="myclass">
		<h2>수강 클래스 정보</h2>
		클래스 번호 :  ${lecture.classNo }<br>
		클래스 이름 : <b>${lecture.className }</b><br>
		클래스 기간 : ${lecture.startDay } ~ ${lecture.endDay }<br>
		학생 수 : ${lecture.studentCnt }
	</div>
	
	<table id="profile">
		<tr>
			<td>식권</td>
			<td>${user.tickets}장</td>
		</tr>
		<tr>
			<td>멀티 포인트</td>
			<td>${user.point}p</td>
		</tr>
		<tr>
			<td colspan="2">현재까지 식권 ${user.total }장을 사용하셨습니다.</td>
		</tr>
	</table>
	
	
	<nav id="topMenu" class="menu">
	<ul>
		<li><a class="menuLink" href="#">식권사용</a></li>
		<li><a class="menuLink" href="#">식권구매</a></li>
		<li><a class="menuLink" href="#">포인트충전</a></li>
	</ul>
	</nav>
<br>
<footer id="bottom" class="menu">
  <p>Posted by: 이효진, 정혜진, 최혜근, 유미선</p>
  <p>Contact information: <a href="mailto:someone@example.com">
  someone@example.com</a>.</p>
</footer>
</body>
</html>