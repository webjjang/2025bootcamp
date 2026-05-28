import { useState, useEffect } from "react";
import axios from "axios";

function BoardList(){
  // -- 데이터 처리 부분 ------------------
  // 데이터를 저장하는 부분
  const [myJSON, setMyJSON] = useState({list:[], pageObject:{}});
  // 데이터 가져오기
  useEffect(
    function(){
      // fetch -> Axios
      axios.get("http://localhost/boardApi/list.do")
      .then((response) => {
        console.log("Axios를 이용한 데이터 가져오기");
        console.log("응답 데이터 : " + response);
        console.log("json 데이터 : " + JSON.stringify(response.data));
        setMyJSON(response.data);
      })
      .catch((error) => {
        console.error("에러 발생 :", error);
      })
      /*
        fetch("http://10.15.21.205/boardApi/list.do") // 데이터 가져오기
        .then((result) => {
            console.log("데이터 : " + result);
            // string -> JSON
            return result.json();
        })
        .then((json) => {
            // JSON을 myJSON에 저장
            console.log("json 데이터 : " + json);
            console.log("json 데이터(문자열) : " + JSON.stringify(json));
            setMyJSON(json);
        })
      */
    }, [] // 빈 배열을 함수 뒤에 선언하면 컴포넌트 호출되면 한번만 실행한다.
  );

  // myJSON 데이터를 가져와서 tag를 만드는 함수
  let trTag = myJSON.list.map(
    (vo) => {
      return (
        <tr className="dataRow" key={vo.no}
         onClick={() => location.href=`./view?no=${vo.no}&inc=1`}>
          <td className="no" >{vo.no}</td>
          <td>{vo.title}</td>
          <td>{vo.writer}</td>
          <td>{vo.writeDate}</td>
          <td>{vo.hit}</td>
        </tr>
      )
    }
  )

  // 데이터 표시 부분
  return(
    <>
      <div>/board/list</div>
      <hr /> <br />
      <table className="table table-hover">
        <thead>
          <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
            <th>조회수</th>
          </tr>
        </thead>
        <tbody>
          {trTag}
        </tbody>
      </table>
      <a href="write" className="btn btn-primary">등록</a>
    </>
  );
}

export default BoardList;