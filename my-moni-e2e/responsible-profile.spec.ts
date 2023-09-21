import { test, expect } from "@playwright/test";
import checkFunds from "./utils/checkFunds";

test.describe("Responsible profile", () => {
  test("should match with poorer revenue", async ({ page }) => {
    await page.goto("http://127.0.0.1:5173/");
    await page.getByLabel("Votre revenu fiscal du foyer").fill("15000");
    await page.getByLabel("Le montant de votre épargne actuelle").fill("1000");
    await page.getByLabel("Acheter ma résidence principale").first().check();
    await page.getByLabel("Acheter ma résidence principale").nth(1).check();
    await page.getByLabel("D'ici 3 à 5 ans").check();
    await page.getByRole("button", { name: "Faire ma simulation" }).click();

    await expect(page.getByText("RESPONSIBLE")).toBeVisible();

    await checkFunds(page, [
      { label: "ESG Obligation europe", repartition: "25 %" },
      { label: "ESG court terme", repartition: "12.5 %" },
      { label: "Echiquier positif impact europe", repartition: "12.5 %" },
      { label: "Duration ESG", repartition: "25 %" },
      { label: "Planète monde", repartition: "25 %" }
    ]);
  });

  test("should match with average revenue", async ({ page }) => {
    await page.goto("http://127.0.0.1:5173/");
    await page.getByLabel("Votre revenu fiscal du foyer").fill("25000");
    await page.getByLabel("Le montant de votre épargne actuelle").fill("3000");
    await page.getByLabel("Acheter ma résidence principale").first().check();
    await page.getByLabel("Acheter ma résidence principale").nth(1).check();
    await page.getByLabel("D'ici 3 à 5 ans").check();
    await page.getByRole("button", { name: "Faire ma simulation" }).click();

    await expect(page.getByText("RESPONSIBLE")).toBeVisible();

    await checkFunds(page, [
      { label: "ESG Obligation europe", repartition: "25 %" },
      { label: "ESG court terme", repartition: "12.5 %" },
      { label: "Echiquier positif impact europe", repartition: "12.5 %" },
      { label: "Duration ESG", repartition: "25 %" },
      { label: "Planète monde", repartition: "25 %" }
    ]);
  });

  test("should not match with higher revenue", async ({ page }) => {
    await page.goto("http://127.0.0.1:5173/");
    await page.getByLabel("Votre revenu fiscal du foyer").fill("35000");
    await page.getByLabel("Le montant de votre épargne actuelle").fill("3000");
    await page.getByLabel("Acheter ma résidence principale").first().check();
    await page.getByLabel("Acheter ma résidence principale").nth(1).check();
    await page.getByLabel("D'ici 3 à 5 ans").check();
    await page.getByRole("button", { name: "Faire ma simulation" }).click();

    await expect(page.getByText("DYNAMIC")).toBeVisible();
  });
});
