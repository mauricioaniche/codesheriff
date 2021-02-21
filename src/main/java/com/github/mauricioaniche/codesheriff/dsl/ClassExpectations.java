package com.github.mauricioaniche.codesheriff.dsl;

import com.github.mauricioaniche.codesheriff.dsl.comparisons.ComparisonOperator;
import com.github.mauricioaniche.codesheriff.expectations.ClassComplexity;
import com.github.mauricioaniche.codesheriff.expectations.ClassCoupling;
import com.github.mauricioaniche.codesheriff.expectations.ClassNumberOfMethods;

public class ClassExpectations {
    private final CodeSheriff sheriff;

    public ClassExpectations(CodeSheriff sheriff) {
        this.sheriff = sheriff;
    }

    public ClassExpectations complexity(ComparisonOperator operator) {
        sheriff.addExpectation(new ClassComplexity(operator));
        return this;
    }

    public ClassExpectations coupling(ComparisonOperator operator) {
        sheriff.addExpectation(new ClassCoupling(operator));
        return this;
    }

    public ClassExpectations numberOfMethods(ComparisonOperator operator) {
        sheriff.addExpectation(new ClassNumberOfMethods(operator));
        return this;
    }
}
