import { useEffect, useRef } from "react";

const UseRefExam2 = () => {
  // 데이터 처리 -----------------------
  // useRef 변수 선언
  const passRef1 = useRef();
  const passRef2 = useRef();
  
  useEffect(()=>{
    console.log('passRef', passRef1, passRef2);
    passRef1.current.focus();
  }, []); // 컴포넌트를 호출할 때 한번만 실행

  // 패스워드 검증 - pass1 == pass2
  const checkPassword = () => {
    // passRef1.current - input tag
    // passRef1.current.value - if 문과 사용하면 length가 0 : false, length > 0:true
    // 패스워드 1과 패스워드 2 중에서 한개라도 비어 있으면 실행
    if(!passRef1.current.value || passRef2.current.value == ''){
      alert("비밀번호를 입력해 주세요.");
      passRef1.current.focus();
      return;
    }

    // 패스워드 2개가 다 입력된 경우 처리
    // 패스워드가 같은 경우 처리
    if(passRef1.current.value === passRef2.current.value){
      alert('비밀번호 확인이 완료되었습니다.');
    }
    else { // 비밀번호가 틀린 경우
      // 경고 띄우기
      alert('비밀번호가 일치하지 않습니다.');
      // 비밀번호 지우기
      passRef1.current.value = '';
      passRef2.current.value = '';
      passRef1.current.focus();
    }
  }

  // 데이터 표시 -----------------------
  return(
    <>
      <form>
        패스워드1 : <input type="text" ref={passRef1} name='pass1' /><br/>
        패스워드2 : <input type="text" ref={passRef2} name='pass2' /><br/>
        <button type="button" onClick={checkPassword}>패스워드 확인</button>
      </form>
    </>
  );
}

export default UseRefExam2;