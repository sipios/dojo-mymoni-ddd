package com.mymoni.investorprofile.domain;

import com.mymoni.investorprofile.infrastructure.repository.FundsRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public enum ProfileName {
    SECURE,
    RESPONSIBLE,
    DYNAMIC,
    ADVENTURER;

    private final FundsRepository fundsRepository;

    ProfileName() {
        this.fundsRepository = new FundsRepository();
    }

    public List<Investment> getInvestments() {
        List<Investment> investments = new ArrayList<>();

        switch (this) {
            case SECURE -> investments.addAll(
                this.drawByRisk(new RiskLevel(1), 1, 100)
            );
            case RESPONSIBLE -> {
                investments.addAll(this.drawByRisk(new RiskLevel(1), 1, 25));
                investments.addAll(this.drawByRisk(new RiskLevel(2), 2, 25));
                investments.addAll(this.drawByRisk(new RiskLevel(3), 2, 50));
            }
            case DYNAMIC -> {
                investments.addAll(this.drawByRisk(new RiskLevel(2), 1, 20));
                investments.addAll(this.drawByRisk(new RiskLevel(3), 2, 35));
                investments.addAll(this.drawByRisk(new RiskLevel(4), 2, 45));
            }
            case ADVENTURER -> {
                investments.addAll(this.drawByRisk(new RiskLevel(1), 1, 15));
                investments.addAll(this.drawByRisk(new RiskLevel(3), 1, 25));
                investments.addAll(this.drawByRisk(new RiskLevel(5), 1, 15));
                investments.addAll(this.drawByRisk(new RiskLevel(6), 2, 45));
            }
        }

        return investments;
    }

    private List<Investment> drawByRisk(
        RiskLevel riskLevel,
        int numberOfWantedFunds,
        int share
    ) {
        BigDecimal shareValue = BigDecimal.valueOf(
            share / (numberOfWantedFunds)
        );

        return fundsRepository
            .all()
            .stream()
            .filter(fund -> fund.riskLevel().equals(riskLevel))
            .limit(numberOfWantedFunds)
            .map(fund -> new Investment(fund, shareValue))
            .toList();
    }
}
