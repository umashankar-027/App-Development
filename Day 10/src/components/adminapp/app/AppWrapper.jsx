import { forwardRef } from "react";
import AdminNav from "./components/AdminNav";
import AdminBody from "./components/AdminBody";
import "./style/appwrapper.css";

const AppWrapper = forwardRef(({}, ref) => {
  return (
    <>
      <div className="appwrapper-w">
        <AdminNav ref={ref} />
        <AdminBody />
      </div>
    </>
  );
});
export default AppWrapper;
