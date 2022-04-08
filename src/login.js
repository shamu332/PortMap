import * as React from "react";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";

function Login() {
  return (
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
      {"Login"}
      <div style={{ position: "relative", top: "12%", height: "30%" }}>
        <TextField id="outlined-basic" label="Username" variant="outlined" />
      </div>
      <div style={{ position: "relative", top: "13%", height: "30%" }}>
        <TextField
          id="outlined-password-input"
          label="Password"
          type="password"
        />
      </div>
    </Box>
  );
}

export default Login;
