<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
					"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입실패</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/main_style.css" />
<script type="text/javascript">
	alert("클래스를 선택해주세요.");
</script>
</head>
<body style="text-align: center;">
	
	<header>
	<a id="logo" href="./main"> 
	<img id="logoimg" width="350px" src="<%=request.getContextPath()%>/resources/images/logo.png" >
	</a>
	<!-- Display the countdown timer in an element -->
	<br>
	</header>
	<hr>

	

	<div class="login">
		<div class="login-triangle"></div>
		
		<h2 class="login-header">Sign up</h2>

		<form class="login-container" action="/edu/signup" method="post">
			<p>
				<input type="text" placeholder="id" name="id" required/>
			</p>
			<p>
				<input type="password" placeholder="password" name="pw" required/>
			</p>
			<p>
				<input type="text" placeholder="name" name="name" required/>
			</p>
			<p>
				<select name="classNo">
					<option class="option" selected disabled>클래스를 선택하세요.</option>
					<c:forEach items="${clist}" var="vo">
						<option class="option" value=${vo.classNo }>
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