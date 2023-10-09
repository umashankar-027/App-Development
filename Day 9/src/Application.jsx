import { lazy, Suspense, useState } from "react";
import ContextTag from "./components/utilityFiles/ContextTag";
import Loading from "./components/utilityFiles/Loading";

export default function Application() {
  // router config
  const [route, setRoute] = useState(window.location.pathname);
  // route configs
  const allHomeMatch = /\/home.*/;
  const allProfileMatch = /\/profile.*/;
  const allAdminMatch = /\/admin.*/;
  return (
    <>
      <ContextTag.Provider value={{ setRoute, route }}>
        <Suspense fallback={<Loading />}>
          {(() => {
            if (route.match(allHomeMatch)) {
              const Page = lazy(() => import("./components/app/AppWrapper"));
              return (
                <>
                  <Page />
                </>
              );
            } else if (route.match(allAdminMatch)) {
              const Page = lazy(() =>
                import("./components/adminapp/AdminAppWrapper")
              );
              return (
                <>
                  <Page />
                </>
              );
            } else if (route.match(allProfileMatch)) {
              const Page = lazy(() =>
                import("./components/app/userpage/Profile")
              );
              return (
                <>
                  <Page />
                </>
              );
            } else {
              const Page = lazy(() =>
                import("./components/loginsignup/LoginSignup")
              );
              return (
                <>
                  <Page />
                </>
              );
            }
          })()}
        </Suspense>
      </ContextTag.Provider>
    </>
  );
}
