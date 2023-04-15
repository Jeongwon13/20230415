<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>글 내용</h3>
	<form action="board/boardList">
	<c:forEach var="board" items="${list}">
	<p>번호: ${board.num}</p>
	<p>제목: ${board.title}</p>
	<p>작성자: ${board.writer}</p>
	<p>내용: ${board.content}</p>
	<p>작성일: ${board.regdate}</p>
	<p>조회수: ${board.cnt}</p>
	</c:forEach>
	
 	<button>수정</button> </a>
 	</form>
</body>
</html>