package com.mymoni.investorprofile.domain;

public enum Goal {
    PRINCIPAL_RESIDENCE(1),
    PROFESSIONAL_PROJECT(2),
    RETIREMENT(3),
    GROW_MY_ASSET(5);

    private final int weigth;

    Goal(int weigth) {
        this.weigth = weigth;
    }

    int weight() {
        return weigth;
    }
}
