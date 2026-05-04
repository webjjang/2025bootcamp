<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>${title }</h3>
<table class="table">
	<tr>
		<th>아이디</th>
		<td>${vo.id }</td>
	</tr>
	<tr>
		<th>이름</th>
		<td>${vo.name }</td>
	</tr>
	<tr>
		<th>성별</th>
		<td>${vo.gender }</td>
	</tr>
	<tr>
		<th>생년월일</th>
		<td>${vo.birth }</td>
	</tr>
	<tr>
		<th>연락처</th>
		<td>${vo.tel }</td>
	</tr>
	<tr>
		<th>이메일</th>
		<td>${vo.email }</td>
	</tr>
	<tr>
		<th>회원 가입일</th>
		<td>${vo.regDate }</td>
	</tr>
	<tr>
		<th>최근 접속일</th>
		<td>${vo.conDate }</td>
	</tr>
	<tr>
		<th>회원 등급명</th>
		<td>${vo.gradeName }</td>
	</tr>
</table>
</body>
</html>