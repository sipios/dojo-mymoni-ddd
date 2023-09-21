import React from "react";
import { AppBar, Box, Toolbar, Typography } from "@mui/material";

const HeaderComponent: React.FC = () => {
  return (
    <Box sx={{ flexGrow: 1 }}>
      <AppBar position="static">
        <Toolbar>
          <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
            MyMoni
          </Typography>
        </Toolbar>
      </AppBar>
    </Box>
  );
};

export default HeaderComponent;
