//Set the date we're counting down to
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
			var ms = Math.floor((distance % (1000)));
			// Display the result in the element with id="demo"
			document.getElementById("demo").innerHTML = "점심시간까지 <b>" + hours
					+ "시간 " + minutes + "분 " + seconds + ":" + ms
					+ "초</b> 남았습니다^^*";

		}, 1);