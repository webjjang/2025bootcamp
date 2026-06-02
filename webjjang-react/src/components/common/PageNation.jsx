
// 컴포넌트에서 Spring Boot에서 넘어오는 pageObject를 
const PageNation = ({pageObject}) => {
  // 데이터 처리
  console.log("pageObject=",JSON.stringify(pageObject));

  const liTag = [];

  // 맨 앞 페이지(1페이지) 이동 코드 작성
  liTag.push(
      <li className={(pageObject.page==1)?"page-item disabled":"page-item"}>
        <a className="page-link" href="#">&lt;&lt;</a>
      </li>
  );
  // 시작페이지의 이전 페이지
  liTag.push(
      <li className={(pageObject.startPage==1)?"page-item disabled":"page-item"}>
        <a className="page-link" href="#">&lt;</a>
      </li>
  );

  // 페이지 클릭 버튼
  for(let i=pageObject.startPage; i <= pageObject.endPage; i++){
    liTag.push(
      <li className="page-item"><a className="page-link" href="#">{i}</a></li>
    );
  }

  // 끝 페이지의 다음 페이지
  liTag.push(
      <li className={(pageObject.totalPage > pageObject.endPage)?"page-item":"page-item disabled"}>
        <a className="page-link" href="#">&gt;</a>
      </li>
  );

  // 마지막 페이지 가기
  liTag.push(
      <li className={(pageObject.totalPage > pageObject.page)?"page-item":"page-item disabled"}>
        <a className="page-link" href="#">&gt;&gt;</a>
      </li>
  );

  // 데이터 표시
  return (
    <div>
      <ul className="pagination pagination-lg">
        {liTag}
      </ul>
    </div>
  )
}

export default PageNation;