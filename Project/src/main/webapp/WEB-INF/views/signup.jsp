<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
					"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/style.css" />

</head>
<body style="text-align: center;">
	<a id="logo" href="./main"> <img
		src="https://www.multicampus.com/img/saas/main/logo/CUS0001/pc_main.png">
	</a>
	<header>
	<h1>MultiCampus 식당</h1>

	<!-- Display the countdown timer in an element -->
	<p id="demo">회원가입</p>
	<br>
	</header>
	<hr>

	

	<div class="login">
		<div class="login-triangle"></div>
		
		<h2 class="login-header">Sign up</h2>

		<form class="login-container" action="/edu/signup" method="post">
			<p>
				<input type="text" placeholder="id" name="id" />
			</p>
			<p>
				<input type="password" placeholder="password" name="pw" />
			</p>
			<p>
				<input type="text" placeholder="name" name="name" />
			</p>
			<p>
				<select>
					<c:forEach items="${clist}" var="vo">
						<option name="classNo" value=${vo.classNo }>
							${vo.className }</option>
					</c:forEach>
				</select>
			</p>
			<p>
				<input type=submit name="button" value="가입등록" /> &nbsp; <input
					type=reset value="다시쓰기" />
			</p>
		</form>
	</div>







	<footer id="bottom" class="menu">
	<p>Posted by: 유미선, 최혜근, 정헤진, 이효진</p>
	<p>
		Contact information: <a href="mailto:someone@example.com">someone@example.com</a>.
	</p>
	</footer>



</body>
</html>