package com.mymoni.investorprofile.infrastructure.dto;

import com.mymoni.investorprofile.domain.*;

public record InvestorProfileFilterRequestDTO(
    int revenue,
    int savings,
    String goal,
    String vision,
    String availability
) {
    public InvestorProfileFilter toDomain() {
        return new InvestorProfileFilter(
            new Revenue(revenue),
            new Savings(savings),
            Goal.valueOf(goal),
            Vision.valueOf(vision),
            Availability.valueOf(availability)
        );
    }
}
