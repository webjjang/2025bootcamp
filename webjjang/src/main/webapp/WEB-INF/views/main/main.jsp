<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>웹짱:${title }</title>

<!-- web 라이브러리를 등록 -->
<!-- Bootstrap 라이브러리 등록 --------- -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<!-- jQuery 라이브러리 등록 - 자바스크립트 함수 : jQuery() ==> $() -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<!-- jQuery UI 라이브러리 등록 : datepicker 등 -->
<link rel="stylesheet" href="https://code.jquery.com/ui/1.14.2/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.14.2/jquery-ui.js"></script>

<!-- icon lib 등록 - awesome 4 -->
<link rel="stylesheet"
 href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<script type="text/javascript">
$(function(){
	// 모달 창을 띄운다.
	${(!empty msg)?"$('#msgModal').modal('show');":""}
});
	// ${(!empty msg)?"alert('" += msg += "');":""}
</script>

</head>
<body>
<!-- @include 디렉티브 태그 - 소스 복붙, jsp:include 액션 태그 - 메서드 실행하고 돌아온다. -->
<jsp:include page="header.jsp"/>
<div style="margin: 80px auto" class="container">
	<jsp:include page="${contentPage }"/>
</div>
<jsp:include page="footer.jsp"/>


<!-- The Modal -->
<div class="modal" id="msgModal">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">처리 결과</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        ${msg }
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>


</body>
</html>