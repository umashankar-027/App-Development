import HeaderLogoDiv from "./HeaderLogoDiv";
import "./style/headerpart2.css";
import MyLink from "../../utilityFiles/RouterConfig/MyLink";

export default function HeaderPart2({ name }) {
  return (
    <>
      <div className="headerpart2-wrapper">
        <HeaderLogoDiv />
        <div className="hd-p2-div3">
          {/* user */}
          <div className="hd-p2-div3-content">
            <MyLink to={name ? "/profile" : "/"}>
              <span
                style={{ "--iconsize": "45px" }}
                className="material-symbols-outlined material-symbols-outlined-color material-symbols-outlined-size-customized material-symbols-outlined-size-customized-mob"
              >
                person
              </span>
              <div className="hd-p2-div3-person-d-div">
                {/* checking if name exist*/}
                {name ? (
                  <>
                    <MyLink to={"/"} noaction={true}>
                      <span className="A-U-N">{name}</span>
                    </MyLink>
                  </>
                ) : (
                  <>
                    <MyLink to={"/"}>
                      <span>Login/Sign up</span>
                    </MyLink>
                  </>
                )}
                <span>Account</span>
              </div>
            </MyLink>
          </div>
          {/* cart */}
          <div
            style={{ "--cartcount": "0" }}
            className="hd-p2-div3-content hd-p2-div3-cart"
          >
            <MyLink to={"/"} noaction={true}>
              <span
                style={{ "--iconsize": "40px" }}
                className="material-symbols-outlined material-symbols-outlined-color material-symbols-outlined-size-customized material-symbols-outlined-size-customized-mob"
              >
                shopping_cart
              </span>
              <span>CART</span>
            </MyLink>
          </div>
        </div>
      </div>
    </>
  );
}
