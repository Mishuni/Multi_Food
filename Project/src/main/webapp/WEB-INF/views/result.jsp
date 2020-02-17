<%@page import="com.pjt.edu.user.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
					"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>작업완료</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/style.css" />


<script>
window.onload = function() {	   
   alert("작업이 완료됐습니다");
   opener.document.location.reload();
   self.close();
} 

</script>
</head>
<body>
	<a id="logo" href="./main"> <img
		src="https://www.multicampus.com/img/saas/main/logo/CUS0001/pc_main.png">
	</a>


</body>
</html>