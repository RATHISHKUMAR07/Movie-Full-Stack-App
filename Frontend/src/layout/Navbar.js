import { Link } from "react-router-dom";
import '../form.css';
export default function Navbar() {
  return (
    <div>
      <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
      <div className="container-fluid">
          <a className="navbar-brand" href="#">Movie Management System</a>
          <button
            className="navbar-toggler"
              type="button"
              data-bs-toggle="collapse"
              data-bs-target="#navbarSupportedContent"
              aria-controls="navbarSupportedContent"
              aria-expanded="false"
              aria-label="Toggle navigation">
              <span className="navbar-toggler-icon"></span>
          </button>

          <Link className="btn btn-light" to="/addmovie">Add Movie</Link>
      </div>
      </nav>
    </div>
  )
}
