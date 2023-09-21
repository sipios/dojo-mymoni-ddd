import React, { useState } from "react";
import ScoringView, { ScoringResult } from "./components/ScoringView.tsx";
import FormComponent from "./components/FormComponent";

export interface FormFields {
  revenue: string;
  savings: string;
  goal: string;
  vision: string;
  availability: string;
}

const ScorerComponent: React.FC = () => {
  const [scoringResult, setScoringResult] = useState<ScoringResult | null>(
    null,
  );

  const [formFields, setFormFields] = useState<FormFields>({
    revenue: "",
    savings: "",
    goal: "",
    vision: "",
    availability: "",
  });

  const handleChange = (name: string, value: string) => {
    setFormFields((prevFields) => ({ ...prevFields, [name]: value }));
  };

  const handleSubmit = () => {
    const requestOptions = {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(formFields),
    };
    fetch("http://localhost:8080/investor-profile", requestOptions)
      .then((res) => res.json())
      .then((result) => {
        setScoringResult(result);
      });
  };

  const resetSimulation = () => {
    setScoringResult(null);
  };

  if (scoringResult) {
    return (
      <ScoringView
        scoringResult={scoringResult}
        resetSimulation={resetSimulation}
      />
    );
  }

  return (
    <FormComponent
      formFields={formFields}
      handleChange={handleChange}
      handleSubmit={handleSubmit}
    />
  );
};

export default ScorerComponent;
