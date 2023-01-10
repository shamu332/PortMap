import React from "react";
import ReactDOM from "react-dom";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Results from "./pages/Results";
import Scanner from "./pages/Scanner";

ReactDOM.render(
  <>
    <Router>
      <Routes>
        <Route path="/" element={<Scanner />} />
        <Route path="/results" element={<Results />} />
      </Routes>
    </Router>
  </>,
  document.getElementById("root")
);
