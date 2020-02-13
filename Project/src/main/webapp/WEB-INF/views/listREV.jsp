<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
					"http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
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
		<li><a class="menuLink" href="./listREV">식단 후기</a></li>
		<li><a class="menuLink" href="#">식단 건의사항</a></li>
		<li><a class="menuLink" href="#">외부식당후기</a></li>
	</ul>
	</nav>
	<br>

	<hr>
	<h1>멀티캠퍼스 식단 후기입니다</h1>
	<table>
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성날짜</td>
			<td>조회수</td>
		</tr>
		<c:forEach items="${list}" var="vo">


			<tr>
				<td>${vo.seq}</td>
				<td><a class="menuLink" href="./detailREV">${vo.title}</a></td>
				<td>${vo.writer}</td>
				<td>${vo.regdate}</td>
				<td>${vo.viewcount}</td>

			</tr>

		</c:forEach>
	</table>

	<input type="button" value="글쓰기"
		onClick="location.href='./insertformREV'">

	<hr>

	<nav id="topMenu" class="menu">
	<ul>
		<li><a href="./useticket"
			onclick="window.open(this.href,'','width=510, height=620, scrollbars=yes'); return false;"
			target="_blank">식권사용</a></li>



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

