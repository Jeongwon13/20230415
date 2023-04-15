<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 내용</title>
</head>
<body>
	<h3>글 내용</h3>
	 
	<c:forEach var="board" items="${list}">
	<p>번호: ${board.num}</p>
	<p>제목: ${board.title}</p>
	<p>작성자: ${board.writer}</p>
	<p>내용: ${board.content}</p>
	<p>작성일: ${board.regdate}</p>
	<p>조회수: ${board.cnt}</p>
	</c:forEach>
	
	<a href="${contextPath}/board/editForm.jsp?=${board.num}"/><button>수정</button> </a>
</body>
</html>