package com.mymoni.investorprofile.domain;

import java.time.Instant;

public record Fund(String label, RiskLevel riskLevel, Instant ddpec) {}
