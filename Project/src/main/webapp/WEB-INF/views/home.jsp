<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
					"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메인화면</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/style.css" />
<style>

</style>

</head>
<body style="text-align: center;">

	<header>
	<h1>MultiCampus 식당</h1>
	</header>
	<!-- Display the countdown timer in an element -->
	<p id="demo"></p>

	<script>
		// Set the date we're counting down to
		var countDownDate2 = new Date();
		countDownDate2.setHours(12);
		countDownDate2.setMinutes(0);
		countDownDate2.setMilliseconds(0);
		countDownDate = countDownDate2.getTime()
		// Update the count down every 1 second
		var x = setInterval(function() {

			// Get today's date and time
			var now = new Date().getTime();

			// Find the distance between now and the count down date
			var distance = countDownDate - now;
			if (distance < 0) {
				distance = 24 * 60 * 60 * 1000 + distance;
				//clearInterval(x);
				//document.getElementById("demo").innerHTML = "EXPIRED";
			}
			// Time calculations for days, hours, minutes and seconds
			var hours = Math.floor((distance % (1000 * 60 * 60 * 24))
					/ (1000 * 60 * 60));
			var minutes = Math.floor((distance % (1000 * 60 * 60))
					/ (1000 * 60));
			var seconds = Math.floor((distance % (1000 * 60)) / 1000);
			var ms = Math.floor((distance%(1000)));
			// Display the result in the element with id="demo"
			document.getElementById("demo").innerHTML = "점심시간까지 <b>" + hours
					+ "시간 " + minutes + "분 " + seconds + ":"+ms+ "초</b> 남았습니다^^*";

		}, 1);
	</script><hr>
	
	<div id="demo"></div>
	<form
	id="loginform" action="/edu/login" method="post">
		<br>
		<br>
		<br> ID : <input type=text id="id" name="id"> <br>
		<br>
		<br> PASSWORD : <input type=password id="pw" name="pw"> <br>
		<br> <input type=submit value="로그인" />

	</form>
	
	<footer id="bottom" class="menu">
  <p>Posted by: 이효진, 정혜진, 최혜근, 유미선</p>
  <p>Contact information: <a href="mailto:someone@example.com">
  someone@example.com</a>.</p>
</footer>

</body>
</html>