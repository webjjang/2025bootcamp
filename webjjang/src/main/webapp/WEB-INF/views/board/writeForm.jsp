<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일반게시판 글등록</title>
<!-- Bootstrap / jQuery / jQuery UI / icon(Awe some 4) 라이브러리 등록 : main.jsp --------- -->
 
  <script type="text/javascript">
  $(function(){
	  $(".cancelBtn").click(function(){
		 // alert("취소 버튼 클릭~~~!");
		 history.back();
	  });
	  
	  // 댓글 작성 폼에서 submit()이 호출되는 이벤트가 발생되면 처리
	  $("#writeForm").submit(function(){
		  // 비밀번호와 비밀번호 확인 같지 않으면
		 if($("#pw").val() != $("#pw2").val()){
			 alert("비밀번호와 비밀번호 확인은 같아야 합니다."); // 경고창은 띄운다.
			 $("#pw, #pw2").val(""); // 비밀번호와 비밀번호 확인을 지운다.
			 $("#pw").focus();// 커서를 비밀번호에 위치 시킨다.
			 return false; // 페이지를 이동시켜 데이터 전송하는 것을 취소 시킨다.
		 } 
			 
	  });
  });
  </script>
  
</head>
<body>
<div class="container">
	<h2>일반게시판 글등록</h2>
	<!-- URL & Header & body(data) 으로 넘기는 방식 : post -- 넘어가는 데이터가 보이지 않는다. -->
	<form action="write.do" method="post" id="writeForm">
	<input type="hidden" name="perPageNum" value="${param.perPageNum }">
	  <div class="mb-3 mt-3">
	    <label for="title" class="form-label">제목</label>
	    <input type="text" class="form-control" id="title" placeholder="제목을 입력하세요." name="title"
	     title="제목은 필수 입력 항목입니다." required>
	  </div>
	  
	    <div class="mb-3 mt-3">
	      <label for="content">내용</label>
	      <textarea class="form-control" rows="5" id="content" name="content" required
	       placeholder="내용을 입력하세요."></textarea>
	    </div>
	  
	  <div class="mb-3 mt-3">
	    <label for="writer" class="form-label">작성자</label>
	    <input type="text" class="form-control" id="writer" placeholder="작성자를 입력하세요." name="writer" required>
	  </div>
	  <div class="mb-3">
	    <label for="pw" class="form-label">비밀번호</label>
	    <input type="password" class="form-control" id="pw" placeholder="비밀번호를 입력하세요." name="pw" required>
	  </div>
	  <div class="mb-3">
	    <label for="pw2" class="form-label">비밀번호 확인</label>
	    <input type="password" class="form-control" id="pw2" placeholder="비밀번호 확인을 입력하세요." required>
	  </div>
	  <button type="submit" class="btn btn-primary">등록</button>
	  <button type="reset" class="btn btn-warning">새로입력</button>
	  <button type="button" class="cancelBtn btn btn-secondary">취소</button>
	</form>
</div>
</body>
</html>