import './App.css'
import { Routes, Route } from 'react-router-dom'
import TopNavi from './components/TopNavi'
import UseRefExam1 from './components/UseRefExam1'
import UseRefExam2 from './components/UseRefExam2'

function App() {

  return (
    <>
      <TopNavi/>
      <Routes>
        <Route path='/' element={<p>홈입니다.</p>} />
        <Route path='/use-ref1' element={<UseRefExam1/>} />
        <Route path='/use-ref2' element={<UseRefExam2/>} />
      </Routes>
    </>
  )
}

export default App
