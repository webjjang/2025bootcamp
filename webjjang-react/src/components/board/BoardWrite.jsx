function BoardWrite(){
  // 데이터 처리 - 데이터 표시 전에 처리, 후에 처리 가능

  // 데이터 표시
  return(
    <>
      <div>/board/write</div>
      <hr />
      <p>일반 게시판 글등록 페이지 입니다.</p>
      <form>
        <div class="mb-3 mt-3">
          <label for="title" class="form-label">제목:</label>
          <input type="text" class="form-control" id="title"
           placeholder="제목 입력" name="title" required maxLength={100}/>
        </div>

        <div class="mb-3 mt-3">
          <label for="content">내용:</label>
          <textarea class="form-control" rows="5" id="content"
           name="content" required></textarea>
        </div>

        <div class="mb-3 mt-3">
          <label for="writer" class="form-label">작성자:</label>
          <input type="text" class="form-control" id="writer"
           placeholder="작성자 입력" name="writer" required maxLength={10}/>
        </div>

        <div class="mb-3">
          <label for="pw" class="form-label">비밀번호:</label>
          <input type="password" class="form-control" id="pw"
           placeholder="비밀번호를 입력하세요" name="pw" required maxLength={20} />
        </div>

        <div class="mb-3">
          <label for="pw2" class="form-label">비밀번호 확인:</label>
          <input type="password" class="form-control" id="pw2"
           placeholder="비밀번호 확인을 입력하세요" required maxLength={20} />
        </div>

        <button type="submit" className="btn btn-primary mr-2">등록</button>
        <button type="reset" className="btn btn-success mr-2">새로입력</button>
        <button type="button" className="btn btn-warning">리스트</button>

      </form>
    </>
  );
}

export default BoardWrite;