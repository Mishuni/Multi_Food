<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
					"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<style>
table {
	width: 500px;
}

td {
	padding: 10px;
	border: 1px solid #666666;
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자 페이지</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/style.css" />

</head>
<body>
	<img id="logo" alt=""
		src="https://www.multicampus.com/img/saas/main/logo/CUS0001/pc_main.png">

	<nav id="topMenu" class="menu">
	<ul>
		<li><a class="menuLink" href="#">오늘의 메뉴</a></li>
		<li><a class="menuLink" href="#">식단 후기</a></li>
		<li><a class="menuLink" href="#">식단 건의사항</a></li>
		<li><a class="menuLink" href="#">수업 후기</a></li>
	</ul>
	</nav>
	<br>

	<div align="center">
		<h1>SUGBoard!!</h1>
		<table border="1">
			<thead>
				<tr>
					<th>#</th>
					<th>제목</th>
					<th>등록자</th>
					<th>조회수</th>
				</tr>
			</thead>

			<c:forEach items="${list}" var="vo">
				<tr>
					<td>${vo.seq}</td>
					<td><a href="detailSUG?seq=${vo.seq}">${vo.title}</a></td>
					<td>${vo.writer}</td>
					<td>${vo.viewcount}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

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
	<p>
		Contact information: <a href="mailto:someone@example.com">someone@example.com</a>.
	</p>
	</footer>



</body>
</html>