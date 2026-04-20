<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>일반 게시판 글등록 폼</title>
	</head>	
	<body>
		<h3>일반 게시판 글등록 폼</h3>
		<form action="write.do" method="post">
			제목 : <input name="title"><br>
			내용: <textarea rows="3" name="content"></textarea><br>
			작성자 : <input name="writer"><br>
			비밀번호 : <input type="password" name="pw"><br>
			<button>등록</button>
		</form>
	</body>
</html>