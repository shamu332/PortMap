import React, { useState } from "react";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import Button from "@mui/material/Button";
import { useNavigate } from "react-router-dom";
import axios from "axios";

function AccountCreation() {
  const navigate = useNavigate();
  const [username, setUsername] = useState("");
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [firstPassword, setFirstPassword] = useState("");
  const [secondPassword, setSecondPassword] = useState("");
  const [email, setEmail] = useState("");

  const onCreate = () => {
    if (firstPassword === secondPassword) {
      let obj = {
        username: username,
        first_name: firstName,
        last_name: lastName,
        password: secondPassword,
        email: email,
      };
      axios
        .post("http://localhost:8080/api/v1/user", obj)
        .then((response) => {
          console.log(response);
          alert("Account has been created!");
        })
        .catch((error) => {
          console.error("There was an error!", error);
          alert(
            "Sorry! Something wrong with our servers! Please check in again later!"
          );
        });
    } else {
      alert("Confrimation password and password input do not match!");
    }
  };

  return (
    <>
      <Box
        sx={{
          backgroundColor: "#EAEDED",
          borderRadius: "5%",
          position: "relative",
          height: "80vh",
          display: "flex",
          flexDirection: "column",
          fontSize: "250%",
          fontWeight: "500",
          textAlign: "center",
        }}
      >
        <div style={{ position: "relative", top: "5%" }}>
          {"Create an Account"}
        </div>
        <div
          style={{
            position: "relative",
            top: "12%",
            display: "flex",
            justifyContent: "space-between",
            flexDirection: "column",
            height: "50vh",
          }}
        >
          <TextField
            id="Username"
            label="Username"
            variant="outlined"
            onChange={(e) => setUsername(e.target.value)}
          />
          <TextField
            id="FirstName"
            label="First Name"
            variant="outlined"
            onChange={(e) => setFirstName(e.target.value)}
          />
          <TextField
            id="lastName"
            label="Last Name"
            variant="outlined"
            onChange={(e) => setLastName(e.target.value)}
          />
          <TextField
            id="password"
            label="Password"
            type="password"
            onChange={(e) => setFirstPassword(e.target.value)}
          />
          <TextField
            id="password2"
            label="Confrim Password"
            onChange={(e) => setSecondPassword(e.target.value)}
            type="password"
          />
          <TextField
            id="email"
            label="Email"
            onChange={(e) => setEmail(e.target.value)}
          />
        </div>
        <div style={{ position: "relative", top: "20%" }}>
          <Button
            variant="contained"
            onClick={() => {
              onCreate();
            }}
          >
            Create
          </Button>
        </div>
      </Box>
    </>
  );
}

export default AccountCreation;
