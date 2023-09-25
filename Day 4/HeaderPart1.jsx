import { useEffect } from "react";
import "./style/headerpart1.css";

export default function HeaderPart1() {
  useEffect(() => {
    const AllLinks = document.querySelectorAll(".custom-link");
    AllLinks.forEach((elem) => {
      elem.addEventListener("click", (e) => e.preventDefault());
    });
  }, []);

  return (
    <>
      <div className="hd-p1-wrapper">
        <div className="hd-p1-div1">
          <div className="hd-p1-content">
            <a href="/" className="custom-link">
              <span class="material-symbols-outlined material-symbols-outlined-color">
                package_2
              </span>
              <span>Your Order</span>
            </a>
          </div>
          <div className="hd-p1-content">
            <a href="/" className="custom-link">
              <span class="material-symbols-outlined material-symbols-outlined-color">
                favorite
              </span>
              <span>Saved Item</span>
            </a>
          </div>
        </div>
        <div className="hd-p2-div2">
          {/* more item yet to put */}
          <div className="hd-p2-content">
            <a href="/" className="custom-link">
              <span>About Us</span>
            </a>
          </div>
        </div>
      </div>
    </>
  );
}
