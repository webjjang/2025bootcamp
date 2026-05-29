import axios from "axios";
import { useEffect, useState } from "react";
import { useSearchParams } from "react-router-dom";

function BoardView(){
  // 데이터 처리 ---------------------------------------------
  // 파라메터로 넘어오는 데이터 수집 - useLocation
  // const location = useLocation();
  const [searchParams] = useSearchParams();
  const no = searchParams.get('no');
  const inc = searchParams.get('inc');
  // 넘어온 데이터 확인하기
  console.log("no:", no, ", inc:", inc);

  // 서버에서 가져온 데이터를 저장하는 상태 변수
  const [vo, setVo] = useState({});

  // 랜더링 전에 컴포넌트를 처음 실행할 때 Spring Boot Server에서 데이터 가져오기 - useEffect()
  useEffect(()=>{
    axios.get(`http://localhost/boardApi/view.do?no=${no}&inc=${inc}`)
    .then((response) =>{
      // 가져온 데이터 확인
      console.log("json 데이터 : " + JSON.stringify(response.data));
      setVo(response.data);
    }).catch((error)=> {
      console.log(`error : ${error}`);
      alert('데이터를 불러오는 과정에서 에러가 발생했습니다.');
    })
  }, [no, inc]);// 컴포넌트가 호출되면 한번만 실행

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