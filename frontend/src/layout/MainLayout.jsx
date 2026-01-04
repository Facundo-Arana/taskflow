import "./layout.css";


function MainLayout({ children }) {
  return (
    <div className="main-conteiner">

      <div className="main-layout">
       {/*  <h1 className="main-title">Main Layout</h1>
        <hr /> */}
        {children}
      </div>
    </div>
  );
}

export default MainLayout;
