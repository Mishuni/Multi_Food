

        function popup(tickets){
        	//alert(tickets);
        	if(tickets>0){
            	var url = "./useticket";
           		//var name = "popup test";
            	var option = "width = 500, height = 600, top = 100, left = 200, location = no";
            	window.open(url, "_blank", option);
            }
        	else{
        		alert("사용가능한 식권이 없습니다. 식권을 구매해 주세요.");
        	}
		}
		
		// buy some tickets
		function popup2(point){
        	//alert(tickets);
        	if(point>60){
            	var url = "./buyticket";
           		//var name = "popup test";
            	var option = "width = 500, height = 600, top = 100, left = 200, location = no";
            	window.open(url, "_blank", option);
            }
        	else{
        		alert("사용가능한 포인트 없습니다. 포인트를 충전해주세요.");
        	}
        }
		

		
		  function pointpopup(){
	            var url = "./addpoint";
	            var name = "_blank";
	            var option = "width = 500, height = 600, top = 100, left = 200, location = no"
	            window.open(url, name, option);
	        }