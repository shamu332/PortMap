import React, { useState } from "react";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import Button from "@mui/material/Button";
import { useNavigate } from "react-router-dom";

function AccountCreation() {
  const navigate = useNavigate();
  const [username, setUsername] = useState("");
  const [firstPassword, setFirstPassword] = useState("");
  const [secondPassword, setSecondPassword] = useState("");
  const [email, setEmail] = useState("");
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
            onChange={(e) => setUsername(e.target.value)}
          />
          <TextField
            id="lastName"
            label="Last Name"
            variant="outlined"
            onChange={(e) => setUsername(e.target.value)}
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
              navigate(`/`);
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
