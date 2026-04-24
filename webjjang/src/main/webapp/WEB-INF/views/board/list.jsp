<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>일반게시판 리스트</h3>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:forEach items="${list }" var="vo">
			<tr>
				<td>${vo.no }</td>
				<td>
					<a href="view.do?no=${vo.no}&inc=1">
						${vo.title }
					</a>
				</td>
				<td>${vo.writer }</td>
				<td>
					<fmt:formatDate value="${vo.writeDate }" pattern="yyyy-MM-dd"/>
				</td>
				<td>${vo.hit }</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="writeForm.do">등록</a>
</body>
</html>