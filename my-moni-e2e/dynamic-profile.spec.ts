import { test, expect } from "@playwright/test";
import checkFunds from "./utils/checkFunds";

test("Dynamic profile", async ({ page }) => {
  await page.goto("http://127.0.0.1:5173/");
  await page.getByLabel("Votre revenu fiscal du foyer").fill("40000");
  await page.getByLabel("Le montant de votre épargne actuelle").fill("50000");
  await page.getByLabel("Ma retraite").first().check();
  await page.getByLabel("Un mariage / PACS").check();
  await page.getByLabel("Dans les deux ans").check();
  await page.getByRole("button", { name: "Faire ma simulation" }).click();

  await expect(page.getByText("DYNAMIC")).toBeVisible();

  await checkFunds(page, [
    { label: "ESG court terme", repartition: "20 %" },
    { label: "Duration ESG", repartition: "17.5 %" },
    { label: "Planète monde", repartition: "17.5 %" },
    { label: "Echiquier world equity growth", repartition: "22.5 %" },
    { label: "Tikehau cross assets", repartition: "22.5 %" },
  ]);
});
