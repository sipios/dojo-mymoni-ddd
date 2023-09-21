package com.mymoni.investorprofile.domain;

public record Revenue(int revenue) {
    int weight() {
        if (revenue <= 15000) {
            return 1;
        } else if (revenue <= 20000) {
            return 2;
        } else if (revenue <= 30000) {
            return 3;
        } else if (revenue <= 40000) {
            return 4;
        } else {
            return 5;
        }
    }
}
