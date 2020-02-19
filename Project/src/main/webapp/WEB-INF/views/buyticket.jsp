<%@page import="com.pjt.edu.user.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
					"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>식권구매</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script>
			$(document).ready(function(){
				$("[name=ticket]").change(function(){
					var num =  $('input[name=ticket]:checked').val();
					var result = num * 60;
					var p = <%=((UserVO)session.getAttribute("member")).getPoint() %>;
					if(p<result){
						alert("금액 부족");
						$('input[name=buy]').prop("disabled", true);
					}
					else{
						$('input[name=buy]').prop("disabled", false);
					}
					$("[name=money]").text(result + "p 입니다.") ;
				});
			});
	</script>
	
	<link rel="stylesheet" type="text/css"	href="<%=request.getContextPath()%>/resources/style.css" />
</head>
<body>
	<img id="logoimg" width="350px" src="<%=request.getContextPath()%>/resources/images/logo.png" >
	<br>
	<hr>
	<!-- 코드작성 -->
	<div>
	
	<h1><%=((UserVO)session.getAttribute("member")).getName() %> 님의 식권구매창 입니다.<hr></h1>
	현재식권 : <%=((UserVO)session.getAttribute("member")).getTickets() %> 개 <br>
	현재포인트 : <%=((UserVO)session.getAttribute("member")).getPoint() %>p 
	<hr>
	<form action="./buyticketClick" action="post">
		구매 희망 갯수 (개당 60p): 
		
		
		<p>
			<h3><input type="radio" name="ticket" value="1"><label for="1">1개 </label></h3>
			<h3><input type="radio" name="ticket" value="2"><label for="2">2개 </label></h3>
			<h3><input type="radio" name="ticket" value="3"><label for="3">3개 </label></h3>
			<h3><input type="radio" name="ticket" value="4"><label for="4">4개 </label></h3>
			<h3><input type="radio" name="ticket" value="5"><label for="5">5개 </label></h3>
			<h3><input type="radio" name="ticket" value="10"><label for="10">10개 </label></h3>
		</p>

		총 결제 포인트는 <b><p id="money" name="money" ></p></b><br>
		<input class="button" type="submit" name="buy" value="구매"/>
	</form>
	
	
</div>

	<hr>


</body>
</html>