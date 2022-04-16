import React from "react";
import ReactDOM from "react-dom";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Login from "./pages/Login";
import Scanner from "./pages/Scanner";

ReactDOM.render(
  <>
    <Router>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/scanner" element={<Scanner />} />
      </Routes>
    </Router>
  </>,
  document.getElementById("root")
);
