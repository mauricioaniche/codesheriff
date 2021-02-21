package com.github.mauricioaniche.codesheriff.dsl.comparisons;

public class OfExactly implements ComparisonOperator {
    private final int maxValue;

    public OfExactly(int maxValue) {
        this.maxValue = maxValue;
    }

    @Override
    public boolean compare(int value) {
        return value == maxValue;
    }
}
