import { render } from "@testing-library/react";
import HeaderComponent from "./HeaderComponent";

test("renders header text", () => {
  const { getByText } = render(<HeaderComponent />);
  const headerElement = getByText(/MyMoni/i);
  expect(headerElement).toBeInTheDocument();
});
