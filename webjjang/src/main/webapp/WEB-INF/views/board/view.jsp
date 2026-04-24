<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일반 게시판 글보기</title>
</head>
<body>
	<h3>일반 게시판 글보기</h3>
	<table>
		<tr>
			<th>번호</th>
			<td>
				<fmt:formatNumber value="${vo.no }" pattern="#,##0" />
			</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${vo.title }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><pre>${vo.content }</pre></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${vo.writer }</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>
				<fmt:formatDate value="${vo.writeDate }" pattern="yyyy-MM-dd"/>
			</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>
				<fmt:formatNumber value="${vo.hit }" pattern="#,##0" />
			</td>
		</tr>
	</table>
	<br>
	<a href="updateForm.do">수정</a>
	<a href="list.do">리스트</a><br>
	<form action="delete.do" method="post">
		<input name="no" value="${vo.no }" type="hidden">
		비밀번호 입력 <input name="pw" type="password">
		<button>삭제</button>
	</form>
	
</body>
</html>