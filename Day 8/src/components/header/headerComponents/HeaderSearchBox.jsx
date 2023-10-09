import "./style/headersearchbox.css";
export default function HeaderSearchBox() {
  return (
    <>
      <div className="headersearchbox-wrapper">
        <div className="headersearchbox-input-wrapper">
          <input
            placeholder="Search for items"
            type="text"
            className="headersearchbox-input"
          />
        </div>
        {/* handle search */}
        <span
          style={{ "--iconsize": "30px" }}
          className="material-symbols-outlined material-symbols-outlined-size-customized"
        >
          search
        </span>
      </div>
    </>
  );
}
