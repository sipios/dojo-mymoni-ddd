package com.mymoni.investorprofile.domain;

public record Savings(int savings) {
    int weight() {
        if (savings < 60_000) {
            return savings / 10_000;
        } else {
            return 5;
        }
    }
}
