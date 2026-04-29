<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<!-- Bootstrap / jQuery 라이브러리 등록 - main.jsp -->
 
  <script type="text/javascript">
  $(function(){
	  // id check 변수 - false : 사용 불가능(중복), true : 사용 가능
	  let idCheck = false;
	  
	  // 데이터 넘기는(submit()) 처리 - form 데이터에 대한 submit
	  $("#writeForm").submit(function(){
		 // alert("데이터 전송하기 실행");
		 
		 // 비밀번호와 비밀번호 확인 같은 지 확인
		 if($("#pw").val() != $("#pw2").val()){
			 alert("비밀번호와 비밀번호 확인이 같지 않습니다. 다시 입력해 주세요.");
			 $("#pw, #pw2").val("");
			 $("#pw").focus();
			 return false;
		 }
		 
		 // 반드시 중복 아이디 체크를 한 아이디만 사용 가능 처리
		 if(!idCheck){
			 alert("사용 가능한 아이디를 입력해 주세요.");
			 $("#id").focus();
			 return false;
		 }
	  });
	  
	  $(".cancelBtn").click(function(){
		 // alert("취소 버튼 클릭~~~!");
		 history.back();
	  });
	  
	  // 아이디에 키보드 입력 할 때마다 처리
	  $("#id").keyup(function(){
		  idCheck = false;
		 // alert($("#id").val());
		 let id = $(this).val();
		 let len = id.length;
		 // alert(len);
		 if(len == 0) { // 아무 것도 입력을 안한 경우
			 $("#idMsg").removeClass("alert-danger alert-success");
			 $("#idMsg").addClass("alert-danger");
			 $("#idMsg").text(" 아이디를 반드시 입력하셔야 합니다.");
		 } else if(len < 4) { // 1~3 까지의 처리
			 $("#idMsg").removeClass("alert-danger alert-success");
			 $("#idMsg").addClass("alert-danger");
			 $("#idMsg").text(" 아이디는 4자 이상 입력하셔야 합니다.");
		 } else { // 4자 이상이므로 서버에 갔다가 와야한다. - ajax(비동식) 처리를 한다.
			  $.ajax(
				// JSON 데이터 ->
				{
					// 아이디 중복 체크를 위한 처리
					url: "checkId.do?id=" + id, // 서버에 비동기식으로 요청 URI
					// 서버가 정상적으로 동작했을 때 처리 메서드
					success: function(result){ 
						// 데이터를 확인하기 위해서 출력하는 방법 2가지. alert() - 경고 창, console.log() - F12 : console 탭에 출력 
				    	// alert(result);
						console.log("[" + result + "]");
				    	if(result){ // id가 중복이 된경우 lenth가 0보다 크다.
							 $("#idMsg").removeClass("alert-danger alert-success");
							 $("#idMsg").addClass("alert-danger");
							 $("#idMsg").text(" 아이디(" + id + ")는 중복된 아이디입니다. 사용할 수 없습니다.");
				    	} else { // 중복되지 않은 id 인 경우 lenth가 0이 나온다.
							 $("#idMsg").removeClass("alert-danger alert-success");
							 $("#idMsg").addClass("alert-success");
							 $("#idMsg").text(" 아이디(" + id + ")는 사용 가능합니다.");
							 idCheck = true;
				    	}
				    	
				  	}, // success의 끝
					// 서버가 오류가 나면 처리 메서드
				  	error: function(xhr,status,error){
				  		console.log("xhr=" + xhr + ", status=" + status + ", error=" + error);
				  	} // error의 끝
				} // JSON 데이터 끝
			); // $.ajax의 끝
		 } // if else의 끝
		 
	  }); //$("#id").keyup() 의 끝
	  
  }); // $(function(){}) 의 끝
  </script>
  
</head>
<body>
	<h2>회원가입</h2>
	<!-- URL & Header & body(data) 으로 넘기는 방식 : post -- 넘어가는 데이터가 보이지 않는다. -->
	<form action="write.do" method="post" id="writeForm">
	  <div class="mb-3 mt-3">
	    <label for="id" class="form-label">아이디</label>
	    <!-- required : 필수, autofocus : 페이지가 열리면 커서를 위치시킨다.
	      	아이디는 맨 앞자는 영문자로 하고 뒤에는 숫자나 영문자를 사용할 수 있다. 4자~20 -->
	    <input type="text" class="form-control" id="id" placeholder="아이디를 입력하세요." name="id"
	     title="아이디는 영문부터 영숫자만 4~20 사이로 입력하셔야 합니다." required autofocus maxlength="20"
	     pattern="[a-zA-Z][a-zA-Z0-9]{3,19}" >
	    <div class="alert alert-danger" id="idMsg">
		  아이디를 반드시 입력하셔야 합니다.
		</div>
	     
	  </div>
	  
 	  <div class="mb-3">
	    <label for="pw" class="form-label">비밀번호</label>
	    <input type="password" class="form-control" id="pw" placeholder="비밀번호를 입력하세요."
	     title="비밀번호는 4~20자 사이로 입력하셔야 합니다." maxlength="20"
	     name="pw" required pattern=".{4,20}">
	  </div>
	  
	  <div class="mb-3">
	    <label for="pw2" class="form-label">비밀번호 확인</label>
	    <input type="password" class="form-control" id="pw2" placeholder="비밀번호 확인을 입력하세요."
	     title="비밀번호확인은 4~20자 사이로 입력하셔야 합니다." maxlength="20"
	     required pattern=".{4,20}">
	  </div>	
	  
	  <div class="mb-3 mt-3">
	    <label for="name" class="form-label">이름</label>
	    <input type="text" class="form-control" id="name" placeholder="이름을 입력하세요."
	     title = "이름은 2~10자 한글로 입력하세요." pattern="[가-힣]{2,10}"
	     maxlength="10" name="name" required>
	  </div>
	  
	  <!-- 성별 항목에 대한 div 시작 -->
	  <div class="mb-3 mt-3">
		    <label class="form-label">성별</label>
		    <!-- 항목을 한줄로 하기위한 div -->
		  <div class="d-flex p-1">
		    <div class="form-check m-3">
		      <!-- radio 또는 check box 버튼인 input tag를 label로 감싸면 글자를 클릭해도 동작된다. -->
		      <label class="form-check-label" for="gender1">
				  <input type="radio" class="form-check-input" id="gender1" name="gender" 
				   value="남자" checked>남자
			  </label>
			</div>
			<div class="form-check m-3">
			  <label class="form-check-label" for="gender2">
				  <input type="radio" class="form-check-input" id="gender2" name="gender"
				   value="여자">여자
			  </label>
			</div>
		  </div>
		    <!-- 항목을 한줄로 하기위한 div 의 끝 -->
		</div>
	  <!-- 성별 항목에 대한 div 끝 -->
	  
	  <div class="mb-3 mt-3">
	    <label for="birth" class="form-label">생년월일</label>
	    <!-- 숫자나 날짜 같은 크기를 나타내는 데이터인 경우 min 과 max를 선언할 수 있다. -->
	    <input type="date" class="form-control" id="birth" placeholder="이름을 입력하세요."
	     name="birth" required min="1940-01-01" max="2015-12-31">
	  </div>
	  
	  <div class="mb-3 mt-3">
	    <label for="tel" class="form-label">연락처</label>
	    <!-- 숫자나 날짜 같은 크기를 나타내는 데이터인 경우 min 과 max를 선언할 수 있다. -->
	    <input type="tel" class="form-control" id="tel" placeholder="연락처를 입력하세요."
	     title="02-xxx-xxxx 또는 010-xxxx-xxxx 형식으로 입력하세요."
	     name="tel" pattern="0\d{1,2}-\d{3,4}-\d{4}">
	  </div>
	  
	  <div class="mb-3 mt-3">
	    <label for="email" class="form-label">이메일</label>
	    <!-- 숫자나 날짜 같은 크기를 나타내는 데이터인 경우 min 과 max를 선언할 수 있다. -->
	    <input type="email" class="form-control" id="email" placeholder="이메일을 입력하세요."
	     name="email" required maxlength="50" 
	     pattern="[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}"
	    >
	  </div>
	  	  <button type="submit" class="btn btn-primary">등록</button>
	  <button type="reset" class="btn btn-warning">새로입력</button>
	  <button type="button" class="cancelBtn btn btn-secondary">취소</button>
	</form>
</body>
</html>