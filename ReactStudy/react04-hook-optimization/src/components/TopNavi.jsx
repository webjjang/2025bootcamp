import { NavLink } from "react-router-dom";

const TopNavi = () => {
  return (
    <nav>
      <NavLink to={"/"}>Home</NavLink>&nbsp;
      <NavLink to={"/use-ref1"}>useRef1</NavLink>&nbsp;
    </nav>
  );
}

export default TopNavi;