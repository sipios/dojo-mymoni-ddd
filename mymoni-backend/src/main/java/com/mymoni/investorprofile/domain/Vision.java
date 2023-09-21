package com.mymoni.investorprofile.domain;

public enum Vision {
    PRINCIPAL_RESIDENCE(1),
    WEDDING(2),
    COMPANY(4),
    RETIREMENT(3);

    private final int weight;

    Vision(int weight) {
        this.weight = weight;
    }

    int weight() {
        return weight;
    }
}
