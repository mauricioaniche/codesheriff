package com.github.mauricioaniche.codesheriff.dsl;

import com.github.mauricioaniche.codesheriff.expectations.clazz.*;

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

    public ClassExpectations numberOfInnerClasses(ComparisonOperator operator) {
        sheriff.addExpectation(new ClassNumberOfInnerClasses(operator));
        return this;
    }

    public ClassExpectations linesOfCode(ComparisonOperator operator) {
        sheriff.addExpectation(new ClassLOC(operator));
        return this;
    }
}
