import React, { useState } from "react";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import Button from "@mui/material/Button";
import { useNavigate } from "react-router-dom";

function Login() {
  const adminUsername = "admin";
  const adminPassword = "admin123";
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  let navigate = useNavigate();

  const handleRouting = () => {
    return username === adminUsername && password === adminPassword;
  };

  return (
    <>
      <Box
        sx={{
          backgroundColor: "#EAEDED",
          borderRadius: "5%",
          position: "relative",
          top: "100px",
          height: "50vh",
          display: "flex",
          flexDirection: "column",
          fontSize: "250%",
          fontWeight: "500",
          textAlign: "center",
        }}
      >
        <div style={{ position: "relative", top: "5%" }}>{"Welcome!"}</div>
        <div style={{ position: "relative", top: "12%", height: "30%" }}>
          <TextField
            id="Username"
            label="Username"
            variant="outlined"
            onChange={(e) => setUsername(e.target.value)}
          />
        </div>

        <div style={{ position: "relative", top: "13%", height: "30%" }}>
          <TextField
            id="password"
            label="Password"
            type="password"
            onChange={(e) => setPassword(e.target.value)}
          />
        </div>
        <div style={{ position: "relative", top: "5%" }}>
          <Button
            variant="contained"
            onClick={() => {
              handleRouting()
                ? navigate(`/scanner`)
                : alert("Wrong Username/Password Combination!");
            }}
          >
            LOGIN
          </Button>
        </div>
      </Box>
    </>
  );
}

export default Login;
