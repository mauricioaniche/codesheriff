package com.github.mauricioaniche.codesheriff.dsl.comparisons;

public class InBetween implements ComparisonOperator {
    private final int min;
    private final int max;

    public InBetween(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean compare(int value) {
        return value >= min && value <= max;
    }
}
