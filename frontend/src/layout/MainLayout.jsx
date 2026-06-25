import "./layout.css";

function MainLayout({ children }) {
  return (
    <div className="main-container">
      <div className="main-layout">
        {children}
      </div>
    </div>
  );
}

export default MainLayout;
