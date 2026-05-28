import { useSearchParams } from "react-router-dom";

function BoardView(){
  // 데이터 처리 ---------------------------------------------
  // 파라메터로 넘어오는 데이터 수집 - useLocation
  // const location = useLocation();
  const [searchParams] = useSearchParams();
  const no = searchParams.get('no');
  const inc = searchParams.get('inc');
  console.log("no:", no, ", inc:", inc);

  // 랜더링 전에 컴포넌트를 처음 실행할 때 Spring Boot Server에서 데이터 가져오기 - useEffect()
  // 데이터 저장하고 데이터를 이용해서 HTML tag를 만든다.
  return(
    <>
      <div>/board/view</div>
      <hr />
      <p>일반 게시판 글보기 페이지 입니다.</p>
      <a href="update">수정</a>&nbsp;
      <a href="delete">삭제</a>&nbsp;
      <a href="list">리스트</a>&nbsp;
    </>
  );
}

export default BoardView;