

        function popup(tickets){
        	//alert(tickets);
        	if(tickets>0){
            	var url = "./useticket";
           		//var name = "popup test";
            	var option = "width = 500, height = 500, top = 100, left = 200, location = no";
            	window.open(url, "_blank", option);
            }
        	else{
        		alert("사용가능한 식권이 없습니다. 식권을 구매해 주세요.");
        	}
        }