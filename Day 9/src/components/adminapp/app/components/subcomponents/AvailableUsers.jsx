import { useState } from "react";
import useImport from "../../../../utilityFiles/customhooks/useImport";
import "./styles/availableusers.css";
export default function AvailableUsers() {
  const [sellers, setSellers] = useState([]);

  useImport("/UserData/sellerData.js", (data) => setSellers(data));

  return (
    <>
      <div className="a-users-w">
        <div className="a-users-contents">
          <div className="a-users-header">
            <p>Seller Manager</p>
          </div>
          <div className="a-users-u-bar-div">
            <div className="a-user-input-div">
              <input type="text" placeholder="Search Sellers..." />
            </div>
            <div className="a-user-u-bttn-div">
              <button>
                <span
                  style={{ "--iconsize": "25px" }}
                  className="material-symbols-outlined  material-symbols-outlined-color material-symbols-outlined-size-customized"
                >
                  person_add
                </span>{" "}
                Add Seller
              </button>
            </div>
          </div>
          <div className="a-users-details-div">
            <table className="a-users-table">
              <thead className="a-users-thead">
                <tr>
                  <th>Name</th>
                  <th>Email</th>
                  <th>Count</th>
                  <th>Location</th>
                  <th className="a-users-t-h-cen">Actions</th>
                </tr>
              </thead>
              <tbody className="a-users-t-b">
                {sellers.map((elem) => {
                  return (
                    <>
                      <SellerRow
                        count={elem.total_products}
                        email={elem.email}
                        location={elem.location}
                        name={elem.name}
                        key={elem.id}
                      />
                    </>
                  );
                })}
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </>
  );
}
function SellerRow({ name, email, location, count }) {
  return (
    <>
      <tr>
        <td className="a-users-t-b">{name}</td>
        <td>{email}</td>
        <td>{count}</td>
        <td>{location}</td>
        <td className="a-users-t-h-cen">{}</td>
      </tr>
    </>
  );
}
