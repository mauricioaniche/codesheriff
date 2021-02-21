package com.github.mauricioaniche.codesheriff.dsl.comparisons;

public class Comparisons {

    public static ComparisonOperator ofLessThan(int value) {
        return new OfLessThan(value);
    }

    public static ComparisonOperator ofExactly(int value) {
        return new OfExactly(value);
    }

    public static ComparisonOperator inBetween(int min, int max) {
        return new InBetween(min, max);
    }
}
