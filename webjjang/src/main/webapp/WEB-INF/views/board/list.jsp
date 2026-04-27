<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="pageNav" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일반 게시판 리스트</title>

  <!-- Bootstrap 5 lib 등록 : CDN -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>

  <!-- jQueury lib 등록 : CDN -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<!-- icon lib 등록 - awesome 4 -->
<link rel="stylesheet"
 href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


<style type="text/css">
.dataRow:hover{
	cursor: pointer;
}
</style>

<script type="text/javascript">
// body tag의 객체가 다 로딩이 된 후에 function()-익명함수 파라메터로 전달되고 변수에 전달되서 코드가 실행된다.
$(function(){
	// 한 줄에 마우스를 올리거난 내릴 때 배경 색 변경
	$(".dataRow").mouseover(function(){
		$(this).addClass("table-secondary");
	}).mouseout(function(){
		$(this).removeClass("table-secondary");
	});
	
	// 한줄을 클릭하면 글보기로 이동시키자. - 글번호 외 페이지 정보, 검색 정보를 같이 넘겨야 한다.
	$(".dataRow").click(function(){
		let no = $(this).find(".no").text();
		location = "view.do?no=" + no + "&inc=1";
	});
});
</script>

</head>
<body>
<div class="container">
	<h3>일반게시판 리스트</h3>
	<table class="table">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:forEach items="${list }" var="vo">
			<tr class="dataRow">
				<td class="no">${vo.no }</td>
				<td>${vo.title }</td>
				<td>${vo.writer }</td>
				<td>
					<fmt:formatDate value="${vo.writeDate }" pattern="yyyy-MM-dd"/>
				</td>
				<td>${vo.hit }</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<!-- pageNav에 필요한 웹라이브러리 : Bootstarp 5, jQuery 3.x, tag 파일, 아이콘:awesome 4 -->
	<div><pageNav:pageNav listURI="list.do" pageObject="${pageObject }" /></div>
	<a href="writeForm.do" class="btn btn-primary">등록</a>
</div>
</body>
</html>