package com.mymoni.investorprofile.infrastructure.dto;

import com.mymoni.investorprofile.domain.Investment;
import com.mymoni.investorprofile.domain.ProfileName;
import java.math.BigDecimal;
import java.util.List;

public record InvestorProfileResponseDTO(
    String label,
    List<InvestmentDto> investments
) {
    public InvestorProfileResponseDTO(ProfileName profile) {
        this(
            profile.name(),
            profile.getInvestments().stream().map(InvestmentDto::new).toList()
        );
    }
}
