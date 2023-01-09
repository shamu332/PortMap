import React, { useState } from "react";
import Button from "@mui/material/Button";
import Header from "../Header";
import TextField from "@mui/material/TextField";
import CircularProgress from "@mui/material/CircularProgress";
import axios from "axios";

function Scanner() {
  const [loader, setLoader] = useState(false);
  const [ipAddress, setIpAddress] = useState("");
  const [responseData, setResponseData] = useState("");

  function toggleLoader() {
    setLoader(!loader);
  }

  const onSend = async () => {
    let obj = {
      ip_address: ipAddress,
    };
    await axios
      .post("http://localhost:8080/api/v1/user", obj)
      .then(
        (response) => console.log(response),
        setResponseData(response.status)
      )
      .catch((error) => {
        console.error("There was an error!", error);
      });
    if (responseData === 200) {
      axios
        .get("http://localhost:8080/api/v1/user", obj)
        .then((response) => console.log(response))
        .catch((error) => {
          console.error("There was an error!", error);
          alert(
            "Sorry! Something wrong with our servers! Please check in again later!"
          );
        });
    } else {
      alert(
        "Sorry! Something wrong with our servers! Please check in again later!"
      );
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
