<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
					"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자 페이지</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/style.css" />

</head>
<body>
	<img id="logo" alt="" src="https://www.multicampus.com/img/saas/main/logo/CUS0001/pc_main.png">
	
	<nav id="topMenu" class="menu">
	<ul>
		<li><a class="menuLink" href="#">오늘의 메뉴</a></li>
		<li><a class="menuLink" href="#">식단 후기</a></li>
		<li><a class="menuLink" href="#">식단 건의사항</a></li>
		<li><a class="menuLink" href="#">수업 후기</a></li>
	</ul>
	</nav>
	<br>
	
	<form ID="insertform" action="./insertformREV" method="post">
      <table style="padding-top: 50px" align=center width=700 border=0
         cellpadding=2>
         <tr>
            <td height=30 align=center bgcolor= DodgerBlue><font color=white>
                  글쓰기</font></td>
         </tr>
         <tr>
            <td bgcolor=white>
               <table class="table2">
                  <tr>
                     <td>제목</td>
                     <td><input type=text name = title size=30 value="asdf"></td>
                  </tr>

                  <tr>
                     <td>작성자</td>
                     <td><input type=text name = writer size=60></td>
                  </tr>

                  <tr>
                     <td>내용</td>
                     <td><textarea name=contents cols=85 rows=15></textarea></td>
                  </tr>

      
               </table>

               <center>
                  <input type="submit" value="작성">
               </center>
            </td>
         </tr>
      </table>
   </form>

	


	<nav id="topMenu" class="menu">
	<ul>
		<li><a class="menuLink" href="#">식권사용</a></li>
		<li><a class="menuLink" href="#">식권구매</a></li>
		<li><a class="menuLink" href="#">포인트충전</a></li>
	</ul>
	</nav>
	<br>
	
	
	
	<footer id="bottom" class="menu">
		<p>Posted by: 이효진, 정혜진, 최혜근, 유미선</p>
		<p>
			Contact information: <a href="mailto:someone@example.com">someone@example.com</a>.
		</p>
	</footer>
	
	
	
</body>
</html>