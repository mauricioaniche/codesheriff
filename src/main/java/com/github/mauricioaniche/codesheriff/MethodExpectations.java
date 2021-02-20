package com.github.mauricioaniche.codesheriff;

import com.github.mauricioaniche.codesheriff.expectations.MethodComplexity;
import com.github.mauricioaniche.codesheriff.expectations.MethodCoupling;

public class MethodExpectations {
    private final CodeSheriff sheriff;

    public MethodExpectations(CodeSheriff sheriff) {
        this.sheriff = sheriff;
    }

    public MethodExpectations complexityOfLessThan(int complexity) {
        sheriff.addExpectation(new MethodComplexity(complexity));
        return this;
    }

    public MethodExpectations couplingOfLessThan(int coupling) {
        sheriff.addExpectation(new MethodCoupling(coupling));
        return this;
    }
}
