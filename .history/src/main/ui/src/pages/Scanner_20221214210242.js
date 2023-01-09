import React, { useState } from "react";
import Button from "@mui/material/Button";
import Header from "../Header";
import TextField from "@mui/material/TextField";
import CircularProgress from "@mui/material/CircularProgress";

function Scanner() {
  const [loader, setLoader] = useState(false);

  function toggleLoader() {
    setLoader(!loader);
  }

  return (
    <>
      <Header />
      <div
        style={{
          display: "flex",
          justifyContent: "center",
          alignItems: "flex-end",
          height: "30vh",
        }}
      ></div>
      {loader ? (
        <div
          style={{
            display: "flex",
            justifyContent: "center",
            alignItems: "center",
            height: "30vh",
          }}
        >
          <CircularProgress />
        </div>
      ) : (
        <>
          <div
            style={{
              display: "flex",
              justifyContent: "center",
              alignItems: "center",
            }}
          >
            <TextField
              id="outlined-basic"
              label="Enter Your IP Address Here"
              variant="outlined"
            />
          </div>
          <div
            style={{
              display: "flex",
              justifyContent: "center",
              alignItems: "center",
              height: "20vh",
            }}
          >
            <Button onClick={toggleLoader} variant="contained">
              SCAN
            </Button>
          </div>
        </>
      )}
    </>
  );
}

export default Scanner;
