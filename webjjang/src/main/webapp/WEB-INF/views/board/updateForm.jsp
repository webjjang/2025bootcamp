<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일반게시판 글수정 폼</title>
</head>
<body>
	<h3>일반게시판 글수정 폼</h3>
	<form action="update.do" method="post">
		번호 : <input name="no" value="${vo.no }" readonly><br>
		제목 : <input name="title" value="${vo.title }"><br>
		내용 : <textarea rows="5" name="content">${vo.content }</textarea><br>
		작성자 : <input name="writer" value="${vo.writer }"><br>
		비밀번호(본인 확인용) : <input type="password" name="pw"><br>
		<button>수정</button>
	</form>
</body>
</html>