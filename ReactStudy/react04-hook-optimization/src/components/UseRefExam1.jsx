import { useState, useRef } from "react";

const UseRefExam1 = ()=> {
  // 데이터 처리 -----------------------
  // 데이터 저장
  // useState 정의한 저장 상태 - 숫자를 저장한다.
  // 정보가 바뀌면 return 부분에서 랜더링이 다시 일어나서 표시된다.
  // 랜더링이 되더라도 데이터는 유지된다.
  const [stateNum, setStateNum] = useState(0);
  // useRef 정의한 저장 참조 - 숫자를 저장한다.
  // refNum를 사용할 때 refNum.current
  // 정보가 바꿔도 랜더링을 하지 않아서 정보가 표시되지 않다.
  // useRef() - 데이터 처리 용도로만 사용한다. 랜더링이 되더라도 데이터 유지
  const refNum = useRef(0);
  // 일반 변수를 사용 : 지역 변수
  // 랜더링이되면 초기화된다.
  let myNum = 0;

  // 함수 정의 - 메서드 : state 변수 1증가.
  const plusState = ()=>{
    setStateNum(stateNum + 1);
    console.log('State 증가', stateNum);
  }

  // 함수 정의 - 메서드 : ref 변수 1증가.
  const plusRef = ()=>{
    refNum.current = refNum.current + 1;
    console.log('Ref 증가', refNum.current);
  }

  // 함수 정의 - 메서드 : 일반 변수 1증가.
  const plusMyNum = ()=>{
    // myNum = myNum + 1;
    console.log('일반 변수 증가', ++myNum);
  }

  // 데이터 표시
  return(
    <>
      <h2>useRef 사용하기</h2>
      <div>
        <p>State : {stateNum}</p>
        <p>Ref : {refNum.current}</p>
        <p>myNum : {myNum}</p>
        <button onClick={plusState}>State 증가</button>
        <button onClick={plusRef}>Ref 증가</button>
        <button onClick={plusMyNum}>myNum 증가</button>
      </div>
    </>
  );
}

export default UseRefExam1;