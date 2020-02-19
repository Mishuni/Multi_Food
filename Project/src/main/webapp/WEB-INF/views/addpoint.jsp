<%@page import="com.pjt.edu.user.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
					"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>포인트구매</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/style.css" />
</head>
<body>
	<img id="logoimg" width="350px" src="<%=request.getContextPath()%>/resources/images/logo.png" >


	<br>

	<hr>
	<!-- 코드작성 -->
	
	
<h1>	<%=((UserVO)session.getAttribute("member")).getName() %> 님의 포인트충전창 입니다 </h1>

<hr>

	<form action ="./addpointClick" methond ="post">
		<h2>충전하실 포인트를 선택하세요</h2>

		
		<p>
			<h3><input type="radio" name="money" value="60"><label for="60">60p </label></h3>
			<h3><input type="radio" name="money" value="120"><label for="120">120p </label></h3>
			<h3><input type="radio" name="money" value="180"><label for="180">180p </label></h3>
			<h3><input type="radio" name="money" value="240"><label for="240">240p </label></h3>
			<h3><input type="radio" name="money" value="300"><label for="300">300p </label></h3>
			<h3><input type="radio" name="money" value="600"><label for="600">600p </label></h3>
		</p>
		<hr>
		<p>
			<input class="button" type="submit" value="제출" >
		</p>
	</form>








</body>
</html>