import React from "react";
import { Box, Button, Container, Typography } from "@mui/material";

type Investment = {
  label: string;
  share: number;
};

export type ScoringResult = {
  label: string;
  investments: Investment[];
};

type Props = {
  scoringResult: ScoringResult;
  resetSimulation: () => void;
};

const ScoringView: React.FC<Props> = ({ scoringResult, resetSimulation }) => {
  return (
    <Container
      sx={{
        mt: 5,
        display: "flex",
        flexDirection: "column",
        alignItems: "center",
      }}
      maxWidth="md"
    >
      <Box sx={{ mb: 3 }}>
        <Typography variant="h3">
          Découvrez votre profil d'investisseur
        </Typography>
      </Box>
      <Box sx={{ mb: 3 }}>
        <Typography variant="h4">{scoringResult.label}</Typography>
      </Box>
      <table>
        <tbody>
          {scoringResult.investments.map((investment) => {
            return (
              <tr style={{ height: "35px" }} key={investment.label}>
                <td style={{ width: "70px" }}>{investment.share} %</td>
                <td style={{ width: "200px" }}>{investment.label}</td>
              </tr>
            );
          })}
        </tbody>
      </table>
      <Button style={{ marginTop: "30px" }} variant="contained" onClick={resetSimulation}>
        <Typography variant="button">Refaire une simulation</Typography>
      </Button>
    </Container>
  );
};

export default ScoringView;
