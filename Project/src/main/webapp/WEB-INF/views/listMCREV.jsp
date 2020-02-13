<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
					"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>외부식당 리뷰 목록보기</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/style.css" />

</head>
<body>
	<img id="logo" alt="" src="https://www.multicampus.com/img/saas/main/logo/CUS0001/pc_main.png">
	
	<nav id="topMenu" class="menu">
	<ul>
		<li><a class="menuLink" href="#">오늘의 메뉴</a></li>
		<li><a class="menuLink" href="#">식단 후기</a></li>
		<li><a class="menuLink" href="#">식단 건의사항</a></li>
		<li><a class="menuLink" href="listMCREV">외부식당 후기</a></li>
	</ul>
	</nav>
	<br>
	<hr>
	 
	<!-- 여기 아래부터 -->
	
	<h1> 멀티캠퍼스 역삼/ 외부의 맛집을 소개합니다 </h1>
    
    <table border="1" >
        <thead>
            <tr>
                <th scope="col">글번호</th>
                <th scope="col">제목</th>
                <th scope="col">작성자</th>
                <th scope="col">등록일</th>
                <th scope="col">조회수</th>
            </tr>
        </thead>
        <tbody>
		

		<c:forEach items="${list}" var="vo">
		<tr>
			<td>${vo.seq}</td> 
			<td><a href="detailMCREV?seq=${vo.seq}">${vo.title}</a></td> 
			<td>${vo.writer}</td> 
			<td>${vo.regdate}</td> 
			<td>${vo.viewcount}</td> 
		</tr>
		</c:forEach>
		
        </tbody>
     <!--    <div>
        페이징처리
        </div> -->
    </table>
    <br>
	<input type="button" value="글 작성하기" onClick="location.href='./insertformMCREV'"/>

	<!-- 여기 위까지만  -->
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