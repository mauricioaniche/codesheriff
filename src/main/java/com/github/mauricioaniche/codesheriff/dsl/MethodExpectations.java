package com.github.mauricioaniche.codesheriff.dsl;

import com.github.mauricioaniche.codesheriff.expectations.method.MethodComplexity;
import com.github.mauricioaniche.codesheriff.expectations.method.MethodCoupling;
import com.github.mauricioaniche.codesheriff.expectations.method.MethodLOC;
import com.github.mauricioaniche.codesheriff.expectations.method.MethodNumberOfVariables;

public class MethodExpectations {
    private final CodeSheriff sheriff;

    public MethodExpectations(CodeSheriff sheriff) {
        this.sheriff = sheriff;
    }

    public CodeSheriff complexity(ComparisonOperator operator) {
        sheriff.addExpectation(new MethodComplexity(operator));
        return sheriff;
    }

    public CodeSheriff coupling(ComparisonOperator operator) {
        sheriff.addExpectation(new MethodCoupling(operator));
        return sheriff;
    }

    public CodeSheriff linesOfCode(ComparisonOperator operator) {
        sheriff.addExpectation(new MethodLOC(operator));
        return sheriff;
    }

    public CodeSheriff numberOfDeclaredVariables(ComparisonOperator operator) {
        sheriff.addExpectation(new MethodNumberOfVariables(operator));
        return sheriff;
    }
}
