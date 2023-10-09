import { lazy, Suspense, useContext } from "react";
import HeaderWrapper from "../header/HeaderWrapper";
import ContextTag from "../utilityFiles/ContextTag";
import Loading from "../utilityFiles/Loading";
import FooterWrapper from "../footer/FooterWrapper";
import "./styles/appwrapper.css";

export default function AppWrapper() {
  const { route } = useContext(ContextTag);
  return (
    <>
      <div className="app-wrapper">
        <HeaderWrapper />
        <Suspense fallback={<Loading />}>
          {(() => {
            if (false) {
            } else {
              const Page = lazy(() => import("./home/HomeWrapper"));
              return <Page />;
            }
          })()}
        </Suspense>
        <FooterWrapper />
      </div>
    </>
  );
}
