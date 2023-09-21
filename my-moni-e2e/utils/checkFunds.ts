import { Page } from "@playwright/test";
import checkFund, { Fund } from "./checkFund";

async function checkFunds(page: Page, funds: Fund[]) {
  funds.forEach((fund, index) => checkFund(page, fund));
}

export default checkFunds;
