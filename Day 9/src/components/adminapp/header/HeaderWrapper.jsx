import { forwardRef } from "react";
import LogoIMG from "../../../asserts/logo.png";
import "./components/styles/headerwrapper.css";

const HeaderWrapper = forwardRef(({}, ref) => {
  function onToogle() {
    if (!ref.current?.toogleNav) {
      console.log("function not assigned");
      return;
    }
    ref.current?.toogleNav();
  }
  return (
    <>
      <header className="h-w-w">
        <div className="h-w-i-t-div">
          <div className="h-w-t-w">
            <span
              style={{ "--iconsize": "40px", cursor: "pointer" }}
              className="material-symbols-outlined material-symbols-outlined-color material-symbols-outlined-size-customized"
              onClick={onToogle.bind(this)}
            >
              menu
            </span>
          </div>
          <div className="h-w-i-w">
            <img src={LogoIMG} alt="" />
          </div>
        </div>
        <div className="h-w-lable">@admin panel</div>
      </header>
    </>
  );
});

export default HeaderWrapper;
