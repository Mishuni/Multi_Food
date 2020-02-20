<%@page import="com.pjt.edu.user.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
					"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>식단 후기 글 업로드</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/style.css" />
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
	<div id=menuname>
		<h3>식단 후기 게시판</h3>
		<hr>

	</div>

	<form ID="insertform" action="./insertformREV" method="post">
		<table id = "insert">
			<tr>
				<td><h3 id = "skyblue">여러분의 의견을 들려주세요</h3></td>
			</tr>
			<tr>
				<td bgcolor=white>
					<table class="table2">
						<tr>
							<td>제목</td>
							<td><input type=text name=title size=70></td>
						</tr>

						<tr>
							<td>작성자</td>
							<td><%=((UserVO)session.getAttribute("member")).getId() %></td>
						</tr>

						<tr>
							<td>내용</td>
							<td><textarea name=contents cols=70 rows=20 ></textarea></td>
						</tr>
					</table>

				</td>
			</tr>
		</table>
		<input class="button"  id="sub" type="submit" value="작성">
		<input type="text" name="writer" value="${member.id}" style="display: none;">
			
	</form>
	<br>

	<nav id="topMenu" class="menu">
	<ul>
		<!-- <li><a class="menuLink" href="./useticket">식권사용</a></li> -->
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