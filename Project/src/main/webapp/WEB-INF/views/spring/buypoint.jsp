<%@page import="com.pjt.edu.user.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
					"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>타이틀입력</title>

</head>
<body>
	<a id="logo" href="./mypage"> <img
		src="https://www.multicampus.com/img/saas/main/logo/CUS0001/pc_main.png">
	</a>


	<br>

	<hr>
	<!-- 코드작성 -->
	<div>
	
	<%=((UserVO)session.getAttribute("member")).getId() %> 님의 식구매창 입니다.<hr>
	현재식권 : <%=((UserVO)session.getAttribute("member")).getTickets() %> 개
	<form action="./buyticket" action="post">
		구매 희망 갯수 : 
		<select>
			<option name="buypoint" value="10">10p</option>
			<option name="buypoint" value="30">30p</option>
			<option name="buypoint" value="60">10p</option>
			<option name="buypoint" value="120">10p</option>
			<option name="buypoint" value="200">10p</option>
			<option name="buypoint" value="300">10p</option>
		</select>
	</form>
	
</div>
<input id="button2" type="button" value="구매" onClick="location.href='./buyticketClick'">



	<hr>




	<br>







</body>
</html>