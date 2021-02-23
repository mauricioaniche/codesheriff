package com.github.mauricioaniche.codesheriff.dsl;

import com.github.mauricioaniche.codesheriff.expectations.clazz.*;

public class ClassExpectations {
    private final CodeSheriff sheriff;

    public ClassExpectations(CodeSheriff sheriff) {
        this.sheriff = sheriff;
    }

    public CodeSheriff complexity(ComparisonOperator operator) {
        sheriff.addExpectation(new ClassComplexity(operator));
        return sheriff;
    }

    public CodeSheriff coupling(ComparisonOperator operator) {
        sheriff.addExpectation(new ClassCoupling(operator));
        return sheriff;
    }

    public CodeSheriff numberOfMethods(ComparisonOperator operator) {
        sheriff.addExpectation(new ClassNumberOfMethods(operator));
        return sheriff;
    }

    public CodeSheriff numberOfInnerClasses(ComparisonOperator operator) {
        sheriff.addExpectation(new ClassNumberOfInnerClasses(operator));
        return sheriff;
    }

    public CodeSheriff linesOfCode(ComparisonOperator operator) {
        sheriff.addExpectation(new ClassLOC(operator));
        return sheriff;
    }
}
