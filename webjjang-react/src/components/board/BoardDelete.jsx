import { useState } from "react";

function BoardDelete({no}){
  // 처리 부분
  const [vo, setVo] = useState({no:no, pw:""});

  const setData = (pw)=>{
    setVo({no:vo.no, pw : pw});
  }

  // 표시 부분
  return(
    <div className="alert alert-secondary m-3">
      <form>
        <div className="mb-3">
          <label htmlFor="pw" className="form-label">본인 확인용 비밀번호 :</label>
          <input type="password" className="form-control" id="pw"
           placeholder="비밀번호를 입력하세요" name="pw" required maxLength={20}
           onChange={(e) => setData(e.target.value)} />
        </div>
       
      </form>
    </div>
  );
}

export default BoardDelete;