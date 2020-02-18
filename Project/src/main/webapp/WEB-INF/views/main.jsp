<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
					"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
<%-- <link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/style.css?var=2" /> --%>
	
	<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/main_style.css?var=2" />
<script src="<%=request.getContextPath()%>/resources/js/popup.js"></script>
<style>
</style>

</head>
<body style="text-align: center;">

	<header>
	<img id="logoimg" width="350px" src="<%=request.getContextPath()%>/resources/images/logo.png" >
	</header>
	<!-- Display the countdown timer in an element -->
	<p id="demo"></p>

	<script src="<%=request.getContextPath()%>/resources/js/timer.js"></script>
	<hr>

	<div id="demo"></div>
	<!-- test -->

	<div class="login">
		<div class="login-triangle"></div>

		<h2 class="login-header">Log in</h2>

		<form class="login-container" action="/edu/login" method="post">
			<p>
				<input type=text id="id" name="id" placeholder="id">
			</p>

			<p>
				<input type=password id="pw" name="pw" placeholder="Password">
			</p>

			<p>
				<input type=submit name="button" value="Sign in">
			</p>
			<p>
				<input type=submit name="button" value="Sign up">
			</p>
		</form>
	</div>

	<!-- testend -->

	<footer id="bottom" class="menu">
	<p>Posted by: 유미선, 최혜근, 정혜진, 이효진</p>
	<p>
		Contact information: <a href="mailto:someone@example.com">
			someone@example.com</a>.
	</p>
	</footer>

</body>
</html>