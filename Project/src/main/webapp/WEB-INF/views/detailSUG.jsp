<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
					"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>detail</title>
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
	<%-- form action = "http://localhost:8081/mvc/boardupdate" method = "post">
번호 : <input type="text" name = "seq" value = '${detail.seq}' readonly><br>
제목 : <input type="text" name = "title" value = '${detail.title}'> <br>
내용 : <input type="text" name = "contents" value = '${detail.contents}'><br>
작성자 : <input type="text" name = "writer" value = '${detail.writer}'><br>
작성시간 : <input type="text" name = "time" value = '${detail.time}'readonly><br>
조회수 : <input type="text" name = "viewcount" value = '${detail.viewcount}' readonly><br>

<input type = submit value = "수정">
</form>


<form action = "http://localhost:8081/mvc/boarddelete">
<input type="hidden" name = "seq" value = '${detail.seq}' readonly>
<input type = submit value = "삭제">
</form> --%>
	

	
	<%-- <div align="center">
		<table border="1">
			<thead>
				<tr>
					<td>${detail.seq}</td>
					<td >${detail.title}</td>
					<td>${detail.viewcount}</td> 
				</tr>
			</thead>
			<tbody>
				<tr><td colspan="3">${detail.contents}</td></tr>
				<tr><td colspan="3"><a href="./listSUG">목록으로</a></td></tr>
			</tbody>
		</table>
	</div> --%>
	<div align="center">
		  <table cellpadding="0" cellspacing= "0"border="0"width="540">
		    <tr>
		      <td bgcolor="white"valign="top"style="padding:2px;"width="400">
		        <a href="./listSUG">[ 리스트로 ]</a></td>
		      <td bgcolor="white" valign="top" align="right" width="140">조회수 : ${detail.viewcount}</td>
		    </tr>
		    <tr>
		      <td bgcolor="#aaaaaa" style="padding:2px;" colspan="2">
		        <table cellpadding="0" cellspacing="1" border="0" width="540">
		          <tr>
		            <td width="100" bgcolor="#EFEFEF" align="center" height="20">게시자</td>
		            <td width="44" bgcolor="white">
		             	${detail.writer}
		            </td>
		          </tr>
		          <tr>
		            <td BGCOLOR="#EFEFEF" align="center" valign="middle" height="25">날짜</td>
		            <td bgcolor="white">${detail.regdate}</td>
		          </tr>
		          <tr>
		            <td BGCOLOR="#EFEFEF" align="center" valign="middle" height="25">제목</td>
		            <td bgcolor="white">${detail.title }</td>
		          </tr>
		          <tr VALIGN="top">
		            <td BGCOLOR="#EFEFEF" align="center" valign="middle">내용</td>
		            <td bgcolor= "white"class="content">${detail.contents }</td>
		          </tr>
		        </table>
		      </td>
		    </tr>
		    <tr>
		      <td style="padding-top:2px;" align="right" colspan="2">
		        <table cellpadding="0" cellspacing="0" border="0" width="340">
		          <tr>
		            <td align="right" width= "200"style="padding=0">
		              비밀번호 <input type="password" name="pwd" size="10" class="pwd"></td>
		            <td align="right" width= "100"style="padding=0">
		              <a href="#"${detail.seq}>[수정하기]</a></td>
		            <td align="right" width= "100"style="padding=0">
		              <a href="#">[삭제하기]</a></td>
		          </tr>
		        </table>
		      </td>
		    </tr>
		  </table>
</div>
	

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