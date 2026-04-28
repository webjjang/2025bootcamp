<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="/js/boardreply.js" ></script>
<script src="/js/replyTag.js" ></script>
<script type="text/javascript">
$(function(){
	// alert("HTML이 로딩되면 바로 실행되는 경고창");
	console.log("HTML이 로딩되면 바로 실행되는 로그");
	// 일반 게시판 글번호
	let no = ${vo.no};
	// 댓글의 페이지 - 전역 변수
	let page = 1;
	
	console.log("no = " + no + ", page = " + page);
	
	// 댓글을 가져오자.
	reply.list(no, page);
	
	$("#replyWriteBtn").click(function(){
		// 버튼처리 등록버튼 보이게하기
		$("#modalReplyWriteBtn").show();
		$("#modalReplyUpdateBtn").hide();
		
	});
	
	// 모달의 댓글 등록 버튼을 클릭하면 동작한 처리문 작성
	$("#modalReplyWriteBtn").click(function(){
		// 데이터 수집 -> JSON 데이터로 만든다.
		//  댓글 내용 수집
		let content = $("#modalReplyContent").val();
		//  JSON 데이터로 만들자.
		let replyObj = {"no" : no, "content" : content};
		// 수집한 데이터 확인
		console.log("replyObj = " + JSON.stringify(replyObj));
		// 댓글 등록처리 -> boardreply.js에 코딩
		reply.write(replyObj);
		// 댓글 모달창은 보이지 않게 한다. 데이터를 지운다.
		$("#replyWriteModal").modal("hide");
		$("#modalReplyContent").val("");
		page = 1;
		reply.list(no, page);
	}); // 댓글 등록 처리 끝
	
	// 댓글의 수정버튼 이벤트 처리 -> 새로 Ajax를 이용해서 만들진 것에는 적용이 안됨.
	//  $("#replyUpdateBtn").click(function(){alert("댓글 수정 버튼 클릭");}); //-> 동작 안됨.
	// 새로 만들어진 객체의 이벤트 처리를 위해서 on() 사용해야만한다.
	// 이미 존재하는 객체(태그) 선택하고. on(이벤트, 이벤트 대상이 나중에 생긴 찾는 객체, function(){})
	$("#replyBody").on("click", "#replyUpdateBtn", function(){
		// alert("댓글 수정 버튼 클릭");
		// 모달을 보이게해야 한다. - 데이터를 세팅해야 한다. - 댓글 번호, 댓글 내용
		// 댓글 번호 수집 - > 모달에 댓글번호 안보이게 저장해 놓는다.
		$("#modalReplyRno").val($(this).closest(".dataRow").find(".rno").text());
		// content 데이터 수집 -> modalReplyContent - 넣는다.
		$("#modalReplyContent").val($(this).closest(".dataRow").find(".content>pre").text());
		// 버튼처리 수정버튼 보이게하기
		$("#modalReplyWriteBtn").hide();
		$("#modalReplyUpdateBtn").show();
		// 모달 창 보여주기
		$("#replyWriteModal").modal("show");
	});
	
	
	// 댓글 수정처리.
	//reply.update();
	// 모달의 댓글 수정 버튼을 클릭하면 동작한 처리문 작성
	$("#modalReplyUpdateBtn").click(function(){
		// 데이터 수집 -> JSON 데이터로 만든다.
		//  댓글 번호 수집
		let rno = $("#modalReplyRno").val();
		//  댓글 내용 수집
		let content = $("#modalReplyContent").val();
		//  JSON 데이터로 만들자.
		let replyObj = {"rno" : rno, "content" : content};
		// 수집한 데이터 확인
		console.log("replyObj = " + JSON.stringify(replyObj));
		// 댓글 수정 처리
		reply.update(replyObj);
		// 댓글 모달창은 보이지 않게 한다. 데이터를 지운다.
		$("#replyWriteModal").modal("hide");
		$("#modalReplyContent").val("");
		reply.list(no, page);
	}); // 댓글 등록 처리 끝
	
	// 댓글 삭제처리.
	//reply.delete();
	// 댓글의 수정버튼 이벤트 처리 -> 새로 Ajax를 이용해서 만들진 것에는 적용이 안됨.
	//  $("#replyDeleteBtn").click(function(){alert("댓글 수정 버튼 클릭");}); //-> 동작 안됨.
	// 새로 만들어진 객체의 이벤트 처리를 위해서 on() 사용해야만한다.
	// 이미 존재하는 객체(태그) 선택하고. on(이벤트, 이벤트 대상이 나중에 생긴 찾는 객체, function(){})
	$("#replyBody").on("click", "#replyDeleteBtn", function(){
		// alert("댓글 삭제 버튼 클릭");
		let rno = $(this).closest(".dataRow").find(".rno").text();
		// 취소를 누르면 아무일도 안 일어 난다.
		if(!confirm(rno + "번 댓글을 정말 삭제하시겠습니까?")) return;
		// 삭제 처리하자. -> 확인을 클릭
		// alert("댓글 삭제 처리 : " + rno)
		page = reply.delete(rno, page); // delete 메서드에는 return이 있다.
		reply.list(no, page);
	});
});
</script>
<div class="card">
  <div class="card-header d-flex justify-content-between">
  	<h3>댓글</h3>
  	<c:if test="${!empty login }">
	  	<div>
	  		<button class="btn btn-success" data-bs-toggle="modal"
	  		 data-bs-target="#replyWriteModal" id="replyWriteBtn">등록</button>
	  	</div>
  	</c:if>
  </div>
  <div class="card-body" id="replyBody">
  
	  	<div class="card dataRow">
		  <div class="card-header  d-flex justify-content-between">
		  	<div class="no">번호</div>
		  	<div>작성날짜</div>
		  </div>
		  <div class="card-body content">댓글 내용</div>
		  <div class="card-footer d-flex justify-content-between">
		  	<div>이름(아이디)</div>
		  	<div>
		  		<button class="btn btn-success btn-sm">수정</button>
		  		<button class="btn btn-danger btn-sm">삭제</button>
		  	</div>
		  </div>
		</div>
		
  </div>
  <div class="card-footer">페이지 처리</div>
</div>


<!-- 댓글 등록과 수정할 때 상용되는 모달 -->
<!-- The Modal -->
<div class="modal" id="replyWriteModal">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">댓글 내용 입력</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
      	<input type="hidden" id="modalReplyRno">
        <textarea rows="4" class="form-control" placeholder="댓글을 입력하세요."
         id="modalReplyContent"></textarea>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" id="modalReplyWriteBtn">등록</button>
        <button type="button" class="btn btn-success" id="modalReplyUpdateBtn">수정</button>
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">취소</button>
      </div>

    </div>
  </div>
</div>
