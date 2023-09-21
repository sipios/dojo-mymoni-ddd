package com.mymoni.investorprofile.domain;

public record InvestorProfileFilter(
    Revenue revenue,
    Savings savings,
    Goal goal,
    Vision vision,
    Availability availability
) {
    public ProfileName investorProfile() {
        if (totalWeight() <= 10) {
            return ProfileName.RESPONSIBLE;
        } else if (totalWeight() < 18) {
            return ProfileName.DYNAMIC;
        } else {
            return ProfileName.ADVENTURER;
        }
    }

    private int totalWeight() {
        return (
            revenue.weight() +
            savings.weight() +
            goal.weight() +
            vision.weight() +
            availability.weight()
        );
    }
}
