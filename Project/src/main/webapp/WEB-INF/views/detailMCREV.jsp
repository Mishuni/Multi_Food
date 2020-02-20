<%@page import="com.pjt.edu.user.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
					"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>외부식당 후기 글</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/style.css" />
<script src="<%=request.getContextPath()%>/resources/js/popup.js"></script>
</head>
<body>
	
	<a id = "logo" href="./mypage">
	<img id="logoimg" src="<%=request.getContextPath()%>/resources/images/logo.png" ></a>
	
	<button id = "logout" class="button" onclick="location.href='./logout'" >로그아웃</button>
	
	<nav id="topMenu" class="menu">
	<ul>
		<li><a class="menuLink" href="./todaymenu">오늘의 메뉴</a></li>
		<li><a class="menuLink" href="./listREV">식단 후기</a></li>
		<li><a class="menuLink" href="./listSUG">식단 건의사항</a></li>
		<li><a class="menuLink" href="./listMCREV">외부식당 후기</a></li>
	</ul>
	</nav>
	<br>
	
	<hr>
	<!-- 코드작성 -->
	<div id=menuname>
		<h3>멀티캠퍼스 역삼/ 외부의 맛집을 소개합니다 </h3>
		<hr>

	</div>
	<div align="center">
		  <table cellpadding="0" cellspacing= "0"border="0"width="540">
		    <tr>
		      <td bgcolor="white"valign="top"style="padding:2px;"width="400">
		        <a href="./listMCREV">[ 리스트로 ]</a></td>
		      <td bgcolor="white" valign="top" align="right" width="140">조회수 : ${detail.viewcount}</td>
		    </tr>
		    <tr>
		      <td bgcolor="#aaaaaa" style="padding:2px;" colspan="2">
		        <table cellpadding="0" cellspacing="1" border="0" width="540">
		          <tr>
		            <td width="100" bgcolor="#EFEFEF" align="center" height="20">게시자</td>
		            <td width="44" bgcolor="white" >
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
		          <tr VALIGN="middle">
		            <td height="200" BGCOLOR="#EFEFEF" align="center" valign="middle">내용</td>
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
		           </td>
		            <td align="right" width= "100"style="padding=0">
		              <input class="button" type="button" value="수정하기" onclick="location.href='./updateMCREV?seq=${detail.seq}&writer=<%=((UserVO)session.getAttribute("member")).getId() %>'"></td>
		            <td align="right" width= "100"style="padding=0">
		              <input class="button" type="button" value="삭제하기" onclick="location.href='./deleteMCREV?seq=${detail.seq}&writer=<%=((UserVO)session.getAttribute("member")).getId() %>'"></td>
		          </tr>
		        </table>
		      </td>
		    </tr>
		  </table>
</div>
	<hr>
	


	<nav id="topMenu" class="menu">
	<ul>
		<li><a class="menuLink" onclick= popup(${member.tickets }) >식권사용</a></li>
		<li><a class="menuLink" onclick= popup2(${member.point }) >식권구매</a></li>
		<li><a class="menuLink" onclick= pointpopup() >포인트충전</a></li>
	</ul>
	</nav>
	<br>
	
	
	
	<footer id="bottom" class="menu">
		<p>Posted by: 유미선, 최혜근, 정헤진, 이효진</p>
		<p>
			Contact information: <a href="mailto:someone@example.com">someone@example.com</a>.
		</p>
	</footer>
	
	
	
</body>
</html>