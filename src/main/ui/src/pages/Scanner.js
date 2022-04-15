import React from "react";
import Button from "@mui/material/Button";
import Header from "../Header";

function Scanner() {
  return (
    <>
      <Header />
      <div
        style={{
          display: "flex",
          justifyContent: "center",
          alignItems: "center",
          height: "100vh",
        }}
      >
        <Button variant="contained">SCAN</Button>
      </div>
    </>
  );
}

export default Scanner;
