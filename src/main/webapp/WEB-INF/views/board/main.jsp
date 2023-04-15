
<%@ page language="java" contentType= "text/html; charset=UTF-8" 
	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>
	<header>
		<section>
			<a href="/board/main">
				<img src="${contextPath}/resources/images/porory.jpg" alt="logo" name="logo" width="300px" height="100px">
			</a>
		</section>
		<section>
			<h1>메인!!!!!!!!</h1>

		</section>
		
		<section>

		</section>
	</header>
	<nav>
		<ul>
			<li>
				<a href="#">공지사항</a>
			</li>
			<li>
				<a href="${contextPath}/board/boardList">게시판</a>
			</li>
			<li>
				<a href="#">마음의소리</a>
			</li>
		</ul>

	</nav>
	<main>
		<section>
		
		</section>
		<article>
			<c:choose>
				<c:when test="${not empty sessionScope.loginMember}">
					 
						<section>
							<p>로그인 되었다 환영해~</p>
						</section>
					 
				</c:when>
			</c:choose>
			
		</article>
	</main>
	
</body>
</html>