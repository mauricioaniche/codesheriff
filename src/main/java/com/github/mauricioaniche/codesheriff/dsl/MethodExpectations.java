package com.github.mauricioaniche.codesheriff.dsl;

import com.github.mauricioaniche.codesheriff.dsl.comparisons.ComparisonOperator;
import com.github.mauricioaniche.codesheriff.expectations.method.MethodComplexity;
import com.github.mauricioaniche.codesheriff.expectations.method.MethodCoupling;

public class MethodExpectations {
    private final CodeSheriff sheriff;

    public MethodExpectations(CodeSheriff sheriff) {
        this.sheriff = sheriff;
    }

    public MethodExpectations complexity(ComparisonOperator operator) {
        sheriff.addExpectation(new MethodComplexity(operator));
        return this;
    }

    public MethodExpectations coupling(ComparisonOperator operator) {
        sheriff.addExpectation(new MethodCoupling(operator));
        return this;
    }
}
