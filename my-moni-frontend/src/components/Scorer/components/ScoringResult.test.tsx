import { render, screen, fireEvent } from "@testing-library/react";
import ScoringView from "./ScoringView.tsx"; // Replace with the correct path
import { vi } from "vitest";

describe("ScoringResult", () => {
  const mockScoringResult = {
    label: "Investisseur prudent",
    investments: [
      { label: "amundi 123", share: 0.2 },
      { label: "hsbc 123", share: 0.2 },
      { label: "lcl 123", share: 0.2 },
      { label: "toto 123", share: 0.2 },
      { label: "totoaa 123", share: 0.2 },
    ],
  };

  it("renders the scoring result and handles reset simulation", () => {
    const resetSimulationMock = vi.fn();
    render(
      <ScoringView
        scoringResult={mockScoringResult}
        resetSimulation={resetSimulationMock}
      />,
    );

    expect(screen.getByText(/Investisseur prudent/i)).toBeInTheDocument();

    // Check if allocation names are displayed
    mockScoringResult.investments.forEach((investment) => {
      expect(screen.getByText(investment.label)).toBeInTheDocument();
    });

    // Click the "Refaire une simulation" button
    const resetButton = screen.getByText(/Refaire une simulation/i);
    fireEvent.click(resetButton);

    // Ensure the resetSimulation function is called
    expect(resetSimulationMock).toHaveBeenCalled();
  });
});
