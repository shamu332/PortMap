import React from "react";
import Button from "@mui/material/Button";
import Header from "../Header";
import TextField from "@mui/material/TextField";

function Scanner() {
  return (
    <>
      <Header />
      <div
        style={{
          display: "flex",
          justifyContent: "center",
          alignItems: "flex-end",
          height: "40vh",
        }}
      >
        <TextField id="outlined-basic" label="ip address" variant="outlined" />
      </div>
      <div
        style={{
          display: "flex",
          justifyContent: "center",
          alignItems: "center",
          height: "20vh",
        }}
      >
        <Button variant="contained">SCAN</Button>
      </div>
    </>
  );
}

export default Scanner;
