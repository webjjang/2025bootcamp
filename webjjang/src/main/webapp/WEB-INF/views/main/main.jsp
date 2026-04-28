<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>웹짱:${title }</title>
</head>
<body>
<!-- @include 디렉티브 태그 - 소스 복붙, jsp:include 액션 태그 - 메서드 실행하고 돌아온다. -->
<jsp:include page="header.jsp"/>
<jsp:include page="${contentPage }"/>
<jsp:include page="footer.jsp"/>
</body>
</html>