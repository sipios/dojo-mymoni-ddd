import { expect, Page } from "@playwright/test";

export type Fund = {
  repartition: string | RegExp;
  label: string | RegExp;
};

async function checkFund(
  page: Page,
  { repartition, label }: Fund
) {
  const row = await page.locator("tr", { has: page.getByText(label) });
  await expect(row.getByText(repartition)).toBeVisible();
  await expect(row.getByText(label)).toBeVisible();
}

export default checkFund;
