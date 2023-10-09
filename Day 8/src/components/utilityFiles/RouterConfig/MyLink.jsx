import { useContext } from "react";
import ContextTag from "../ContextTag";

// act similar to link tag in react router dom

export default function MyLink({ to, noaction, children }) {
  const { setRoute } = useContext(ContextTag);

  function onNavigate(event) {
    event.preventDefault();
    if (noaction) return;
    setRoute(to);
    window.history.pushState(null, "", to);
  }

  return (
    <>
      <a href={to} className="custom-link" onClick={onNavigate.bind(this)}>
        {children}
      </a>
    </>
  );
}
