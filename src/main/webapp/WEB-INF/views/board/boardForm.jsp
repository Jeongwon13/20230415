
<%@ page language="java" contentType= "text/html; charset=UTF-8" 
	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<section>
	<form action="${contextPath}/board/boardForm" method="POST" name="board"  >
	<fieldset>
	제목<input type="text" name="title"><br><br>
	작성자<input type="text" name="writer"><br><br>
	이미지 첨부<input type="image" name="image" id="image" value="파일선택"><br><br>
	내용 <textarea name="textarea" cols="30" rows="10"></textarea><br><br>
	<button>등록하기</button>
	</fieldset>
	</form>
	</section>
</body>
</html>