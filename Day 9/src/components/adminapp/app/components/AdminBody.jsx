import { lazy, Suspense, useContext } from "react";
import ContextTag from "../../../utilityFiles/ContextTag";
import Loading from "../../../utilityFiles/Loading";
import "./styles/adminbody.css";

export default function AdminBody() {
  const { route } = useContext(ContextTag);
  return (
    <>
      <div className="adminbody-wrapper">
        <Suspense fallback={<Loading />}>
          {(() => {
            if (route === "/admin/user_accounts") {
              const Page = lazy(() => import("./subcomponents/AvailableUsers"));
              return (
                <>
                  <Page />
                </>
              );
            }
          })()}
        </Suspense>
      </div>
    </>
  );
}
