package com.mymoni.investorprofile.domain;

public enum Availability {
    LESS_THAN_TWO_YEARS(2),
    THREE_TO_FIVE_YEARS(5);

    private final int weight;

    Availability(int weight) {
        this.weight = weight;
    }

    int weight() {
        return weight;
    }
}
