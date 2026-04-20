<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>일반 게시판 리스트</title>
	</head>	
	<body>
		<h3>일반 게시판 리스트</h3>
		<a href="view.do?no=10&inc=1">자바란?</a>
		<br>
		<button onclick="location='writeForm.do'">등록</button><br>
		${list }
	</body>
</html>