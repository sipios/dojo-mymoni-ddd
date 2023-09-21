import { test, expect } from "@playwright/test";
import checkFunds from "./utils/checkFunds";

test("Adventurer profile", async ({ page }) => {
  await page.goto("http://127.0.0.1:5173/");
  await page.getByLabel("Votre revenu fiscal du foyer").fill("50000");
  await page.getByLabel("Le montant de votre épargne actuelle").fill("70000");
  await page.getByLabel("Fructifier mon patrimoine").first().check();
  await page.getByLabel("Un mariage / PACS").check();
  await page.getByLabel("Dans les deux ans").check();
  await page.getByRole("button", { name: "Faire ma simulation" }).click();

  await expect(page.getByText("ADVENTURER")).toBeVisible();

  await checkFunds(page, [
    { label: "ESG Obligation europe", repartition: "15 %" },
    { label: "Duration ESG", repartition: "25 %" },
    { label: "Echiquier positif impact Europe", repartition: "15 %" },
    { label: "Sustainable Equity", repartition: "22.5 %" },
    { label: "Choix solidaire", repartition: "22.5 %" },
  ]);
});
