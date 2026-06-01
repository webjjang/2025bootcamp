import { Routes, Route } from "react-router-dom"; 
import BoardList from "./BoardList";
import NotFoundPage from "../error/NotFoundPage";
import BoardWrite from "./BoardWrite";
import BoardView from "./BoardView";
import BoardUpdate from "./BoardUpdate";
import BoardDelete from "./BoardDelete";

function BoardComp(){
  return (
    <div>
      <h2>일반 게시판</h2>
      <Routes>
        <Route path="list" element={<BoardList /> } />
        <Route path="view" element={<BoardView /> } />
        <Route path="write" element={<BoardWrite /> } />
        <Route path="update" element={<BoardUpdate /> } />
        {/* 글보기 안에 삭제 컴포넌트를 포함 시킨다.
          <Route path="delete" element={<BoardDelete /> } /> */}
        <Route path="*" element={<NotFoundPage />} />
      </Routes>
    </div>
  )
}

export default BoardComp;