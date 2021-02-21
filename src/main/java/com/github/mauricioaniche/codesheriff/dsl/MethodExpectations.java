package com.github.mauricioaniche.codesheriff.dsl;

import com.github.mauricioaniche.codesheriff.dsl.comparisons.ComparisonOperator;
import com.github.mauricioaniche.codesheriff.expectations.method.MethodComplexity;
import com.github.mauricioaniche.codesheriff.expectations.method.MethodCoupling;
import com.github.mauricioaniche.codesheriff.expectations.method.MethodLOC;

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

    public MethodExpectations linesOfCode(ComparisonOperator operator) {
        sheriff.addExpectation(new MethodLOC(operator));
        return this;
    }
}
