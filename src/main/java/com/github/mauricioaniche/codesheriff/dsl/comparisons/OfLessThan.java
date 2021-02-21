package com.github.mauricioaniche.codesheriff.dsl.comparisons;

public class OfLessThan implements ComparisonOperator {
    private final int maxValue;

    public OfLessThan(int maxValue) {
        this.maxValue = maxValue;
    }

    @Override
    public boolean compare(int value) {
        return value < maxValue;
    }
}
