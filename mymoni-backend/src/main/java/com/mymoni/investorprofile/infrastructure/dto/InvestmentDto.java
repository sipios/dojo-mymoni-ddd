package com.mymoni.investorprofile.infrastructure.dto;

import com.mymoni.investorprofile.domain.Investment;
import java.math.BigDecimal;

record InvestmentDto(String label, BigDecimal share) {
    public InvestmentDto(Investment investment) {
        this(investment.fund().label(), investment.share());
    }
}
