import React, { useState } from "react";
import Button from "@mui/material/Button";
import Header from "../Header";
import TextField from "@mui/material/TextField";
import CircularProgress from "@mui/material/CircularProgress";
import axios from "axios";

function Scanner() {
  const [loader, setLoader] = useState(false);
  const [ipAddress, setIpAddress] = useState("");

  function toggleLoader() {
    setLoader(!loader);
  }

  const onSend = async () => {
    let obj = {
      ip_address: ipAddress,
    };
    try {
      const { data } = await axios.post(
        "http://localhost:8080/api/v1/scanner",
        {
          obj,
        }
      );
      const { secondReqData } = await axios.get(
        "http://localhost:8080/api/v1/scanner",
        obj
      );
      console.log("data:", data);
      console.log("second request data", secondReqData);
    } catch (e) {
      console.log(e);
      alert("Uh Oh! Something with wrong with our servers!");
    }
  };

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
              label="Enter Your IP Address"
              variant="outlined"
              onChange={(e) => setIpAddress(e.target.value)}
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
            {/* <Button onClick={toggleLoader} variant="contained">
              SCAN
            </Button> */}
            <Button
              variant="contained"
              onClick={() => {
                onSend();
              }}
            >
              SCAN
            </Button>
          </div>
        </>
      )}
    </>
  );
}

export default Scanner;
