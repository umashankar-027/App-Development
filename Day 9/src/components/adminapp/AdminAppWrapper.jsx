import useMyNavigate from "../utilityFiles/RouterConfig/useMyNavigate";
import HeaderWrapper from "./header/HeaderWrapper";
import AppWrapper from "./app/AppWrapper";
import { useRef } from "react";
import namestore from "../header/headerReducer/namestore";
import "./style/adminappwrapper.css";

export default function AdminAppWrapper() {
  // need to look
  const name = namestore.getState().name.name;
  const myNav = useMyNavigate();
  // if name is false the redirect
  if (!name) {
    myNav("/");
  }
  const navRef = useRef();

  return (
    <>
      <div className="aa-w-w">
        <HeaderWrapper ref={navRef} />
        <AppWrapper ref={navRef} />
      </div>
      <div className="aa-w-on-s-r">Only Available on Big Screens....</div>
    </>
  );
}
