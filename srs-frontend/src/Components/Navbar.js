import React from "react";
import { Link } from "react-router-dom";

function Navbar() {
  return (
    <div>
      <Link to="/">Ship</Link>
      <Link to="/view">Schedule</Link>
      <Link to="/driverlist">Route</Link>
    </div>
  );
}

export default Navbar;
