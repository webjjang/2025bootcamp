<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일반게시판 글보기</title>
</head>
<body>
	<h3>일반게시판 글보기</h3>
	no = ${param.no } / inc = ${param.inc } <br>
	<a href="updateForm.do?no=10">수정</a><br>
	<form action="delete.do" method="post">
		<input type="hidden" name="no" value="10">
		비밀번호 입력 : <input type="password" name="pw"><br>
		<button>삭제</button>
	</form>
</body>
</html>