import { forwardRef, useImperativeHandle, useRef } from "react";
import MyLink from "../../../utilityFiles/RouterConfig/MyLink";
import namestore from "../../../header/headerReducer/namestore";
import "./styles/adminnav.css";

const AdminNav = forwardRef(({}, ref) => {
  const navWrapperRef = useRef();
  // need to look
  const name = namestore.getState().name.name;
  function toogleNav() {
    navWrapperRef.current.classList.toggle("adminnav-wrapper-minized");
  }

  useImperativeHandle(
    ref,
    () => ({
      toogleNav,
    }),
    []
  );
  return (
    <>
      <nav
        className="adminnav-wrapper adminnav-wrapper-minized"
        ref={navWrapperRef}
      >
        <label htmlFor="userNavPMenu">
          <div className="adminnav-user-div">
            <input type="checkbox" id="userNavPMenu" />
            <div className="adminnav-user-profile-div">
              <img
                src={
                  "https://image.tmdb.org/t/p/original/pmi1oaPy4UL6W5x564ToR3AtApY.jpg"
                }
                alt=""
              />
            </div>
            <div className="adminnav-user-nav-div adminnav-close-div">
              <h4>{name}</h4>
              <p>Welcome admin!</p>
            </div>
          </div>
        </label>
        <div className="adminnav-optns-div">
          <ul className="adminnav-optns-ul">
            <MyLink to={"/admin"}>
              <li>
                <div className="adminnav-optns-icon-div">
                  <span
                    style={{
                      "--iconsize": "30px",
                      "--customColor": "royalblue",
                    }}
                    className="material-symbols-outlined material-symbols-outlined-size-customized material-symbols-outlined-custom-color"
                  >
                    dashboard
                  </span>
                </div>
                <div className="adminnav-optns-text-div adminnav-close-div">
                  <span>Dashboard</span>
                </div>
              </li>
            </MyLink>
            <MyLink to={"/admin/user_accounts"}>
              <li>
                <div className="adminnav-optns-icon-div">
                  <span
                    style={{
                      "--iconsize": "30px",
                      "--customColor": "royalblue",
                    }}
                    className="material-symbols-outlined material-symbols-outlined-size-customized material-symbols-outlined-custom-color"
                  >
                    manage_accounts
                  </span>
                </div>
                <div className="adminnav-optns-text-div adminnav-close-div">
                  <span>Manage Seller</span>
                </div>
              </li>
            </MyLink>
            <MyLink to={"/admin/products"}>
              <li>
                <div className="adminnav-optns-icon-div">
                  <span
                    style={{
                      "--iconsize": "30px",
                      "--customColor": "royalblue",
                    }}
                    className="material-symbols-outlined material-symbols-outlined-size-customized material-symbols-outlined-custom-color"
                  >
                    inventory
                  </span>
                </div>
                <div className="adminnav-optns-text-div adminnav-close-div">
                  <span>Manage Products</span>
                </div>
              </li>
            </MyLink>
          </ul>
          <ul className="adminnav-optns-ul">
            <MyLink to={"/"}>
              <li>
                <div className="adminnav-optns-icon-div">
                  <span
                    style={{ "--iconsize": "30px", "--customColor": "red" }}
                    className="material-symbols-outlined material-symbols-outlined-size-customized material-symbols-outlined-custom-color"
                  >
                    logout
                  </span>
                </div>
                <div className="adminnav-optns-text-div adminnav-close-div">
                  <span style={{ color: "hsl(0, 37%, 62%)" }}>Logout</span>
                </div>
              </li>
            </MyLink>
          </ul>
        </div>
      </nav>
    </>
  );
});

export default AdminNav;
