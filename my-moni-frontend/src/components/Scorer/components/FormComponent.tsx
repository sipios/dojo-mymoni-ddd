import React, { ReactNode } from "react";
import {
  Button,
  Container,
  FormControlLabel,
  InputAdornment,
  Radio,
  RadioGroup,
  Stack,
  Typography,
} from "@mui/material";
import TextField from "@mui/material/TextField";
import { FormFields } from "../ScorerComponent";

type Props = {
  formFields: FormFields;
  handleChange: (name: string, value: string) => void;
  handleSubmit: () => void;
};

const FieldBox = (props: { children: ReactNode }) => (
  <div
    style={{
      display: "flex",
      alignItems: "center",
      justifyContent: "space-between",
    }}
  >
    {props.children}
  </div>
);

const FormComponent: React.FC<Props> = ({
  formFields,
  handleChange,
  handleSubmit,
}) => {
  return (
    <Container sx={{ mt: 5 }} maxWidth="md">
      <Typography variant="h3">Simuler votre profil épargnant</Typography>
      <form>
        <Stack spacing={2} sx={{ my: 5 }}>
          <FieldBox>
            <label htmlFor="revenue">Votre revenu fiscal du foyer</label>
            <TextField
              id="revenue"
              name="revenue"
              style={{ width: "300px" }}
              type="number"
              value={formFields.revenue}
              onChange={(e) => handleChange("revenue", e.target.value)}
              InputProps={{
                endAdornment: <InputAdornment position="end">€</InputAdornment>,
              }}
            />
          </FieldBox>

          <FieldBox>
            <label htmlFor="savings">
              Le montant de votre épargne actuelle
            </label>
            <TextField
              id="savings"
              name="savings"
              style={{ width: "300px" }}
              type="number"
              value={formFields.savings}
              onChange={(e) => handleChange("savings", e.target.value)}
              InputProps={{
                endAdornment: <InputAdornment position="end">€</InputAdornment>,
              }}
            />
          </FieldBox>

          <FieldBox>
            <label>J'épargne pour :</label>
            <RadioGroup
              style={{ width: "300px" }}
              name="goal"
              value={formFields.goal}
              onChange={(e) => handleChange("goal", e.target.value)}
            >
              <FormControlLabel
                value="RETIREMENT"
                control={<Radio />}
                label="Ma retraite"
              />
              <FormControlLabel
                value="GROW_MY_ASSET"
                control={<Radio />}
                label="Fructifier mon patrimoine"
              />
              <FormControlLabel
                value="PROFESSIONAL_PROJECT"
                control={<Radio />}
                label="Un projet professionnel"
              />
              <FormControlLabel
                value="PRINCIPAL_RESIDENCE"
                control={<Radio />}
                label="Acheter ma résidence principale"
              />
            </RadioGroup>
          </FieldBox>

          <FieldBox>
            <label>Dans les 5 ans je pense avoir besoin de :</label>
            <RadioGroup
              style={{ width: "300px" }}
              name="vision"
              value={formFields.vision}
              onChange={(e) => handleChange("vision", e.target.value)}
            >
              <FormControlLabel
                value="WEDDING"
                control={<Radio />}
                label="Un mariage / PACS"
              />
              <FormControlLabel
                value="COMPANY"
                control={<Radio />}
                label="Créer une entreprise"
              />
              <FormControlLabel
                value="RETIREMENT"
                control={<Radio />}
                label="Ma retraite"
              />
              <FormControlLabel
                value="PRINCIPAL_RESIDENCE"
                control={<Radio />}
                label="Acheter ma résidence principale"
              />
            </RadioGroup>
          </FieldBox>

          <FieldBox>
            <label>Je vais en avoir besoin dans :</label>
            <RadioGroup
              style={{ width: "300px" }}
              name="availability"
              value={formFields.availability}
              onChange={(e) => handleChange("availability", e.target.value)}
            >
              <FormControlLabel
                value="LESS_THAN_TWO_YEARS"
                control={<Radio />}
                label="Dans les deux ans"
              />
              <FormControlLabel
                value="THREE_TO_FIVE_YEARS"
                control={<Radio />}
                label="D'ici 3 à 5 ans"
              />
            </RadioGroup>
          </FieldBox>
        </Stack>
        <div
          style={{
            display: "flex",
            alignItems: "center",
            justifyContent: "center",
          }}
        >
          <Button variant="contained" onClick={handleSubmit}>
            <Typography variant="button">Faire ma simulation</Typography>
          </Button>
        </div>
      </form>
    </Container>
  );
};

export default FormComponent;
