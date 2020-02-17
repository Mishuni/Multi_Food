<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
					"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/style.css" />

</head>
<body>
	<a id = "logo" href="./main">
	<img src="https://www.multicampus.com/img/saas/main/logo/CUS0001/pc_main.png" >
	</a>
	<header>
	<h1>MultiCampus 식당</h1>
	</header>
	<!-- Display the countdown timer in an element -->
	<p id="demo">회원가입</p>
	<br>
	
	<hr>

	<form
	id="loginform" action="/edu/signup" method="post">
		<br>
		<br> ID : <input type=text id="id" name="id"> <br>
		 PASSWORD : <input type=password id="pw" name="pw"> <br>
		 NAME : <input type=password id="pw" name="name"> <br>
		 CLASS : <select>
		 		<c:forEach items="${clist}" var="vo">
		 			<option  name= "classno" value=${vo.classNo } >
		 				${vo.className }
		 			</option>
		 		</c:forEach>
		 		</select>

		
		<br> <input type=submit name="button" value="가입등록" /> &nbsp;
		 <input type=reset value="다시쓰기" />

	</form>



	
	
	
	<footer id="bottom" class="menu">
		<p>Posted by: 유미선, 최혜근, 정헤진, 이효진</p>
		<p>
			Contact information: <a href="mailto:someone@example.com">someone@example.com</a>.
		</p>
	</footer>
	
	
	
</body>
</html>