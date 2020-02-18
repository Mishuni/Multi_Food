<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
					"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  					
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>식단 건의사항</title>
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
	
	<div id=menuname>
		<h3>건의사항 게시판</h3>
		<hr>

	</div>

	<table class=table2>
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
				<td><a class="menuLink" href="./detailSUG?seq=${vo.seq}" >${vo.title}</a></td>
				<td>${vo.writer}</td>
				<td>${vo.regdate}</td>
				<td>${vo.viewcount}</td>

			</tr>

		</c:forEach>
		<tr>
			<td colspan="2"><c:forEach items="${page}" var="num">
					<a href="./listSUG?num=${num}">${num}</a>| </c:forEach></td>
			<td colspan="2">
				<form action="./listSUG" method="post">
					<select name='choice'>
						<option value='' selected>-- 선택 --</option>
						<option value='title' label="제목" />
						<option value='writer' label="작성자" />
					</select> 
					<input type="text" name="search"/>
					<input type="submit" value="검색">
				</form>
			</td>
			<td><input class="button" type="button" value="글쓰기"
				onClick="location.href='./insertformSUG'"></td>
		</tr>
	</table>


	
	
	


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